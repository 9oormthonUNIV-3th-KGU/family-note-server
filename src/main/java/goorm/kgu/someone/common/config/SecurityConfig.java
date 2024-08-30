package goorm.kgu.someone.common.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()))
			.csrf(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.formLogin(AbstractHttpConfigurer::disable)
			.logout(AbstractHttpConfigurer::disable)
			.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)
			.authorizeHttpRequests(auth -> auth
				.requestMatchers(SWAGGER_PATTERNS).permitAll()
				.anyRequest().authenticated()
			)
			.build();
	}

	private static final String[] SWAGGER_PATTERNS = {
		"/swagger-ui/**",
		"/actuator/**",
		"/v3/api-docs/**",
	};

	@Bean
	public WebSecurityCustomizer configure() {
		return (web) -> web.ignoring()
			.requestMatchers(
				new AntPathRequestMatcher("/img/**"),
				new AntPathRequestMatcher("/css/**"),
				new AntPathRequestMatcher("/js/**")
			);
	}

	CorsConfigurationSource corsConfigurationSource() {
		return request -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedHeaders(Collections.singletonList("*"));
			config.setAllowedMethods(Collections.singletonList("*"));
			config.setAllowCredentials(true);
			return config;
		};
	}
}