package goorm.kgu.familynote.common.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record PageableResponse<T>(
	@Schema(
		defaultValue = "0",
		description = "페이지 인덱스로, 0부터 시작합니다. 별도의 값 없이 요청 시, 0으로 설정됩니다.",
		requiredMode = REQUIRED
	)
	int page,

	@Schema(
		defaultValue = "10",
		description = "페이지 내 최대 응답 개수입니다. 별도의 값 없이 요청 시, 10으로 설정됩니다.",
		requiredMode = REQUIRED
	)
	int size,

	@Schema(
		defaultValue = "3",
		description = "전체 페이지 수입니다.",
		requiredMode = REQUIRED
	)
	int totalPages,

	@Schema(
		defaultValue = "30",
		description = "전체 요소 갯수 입니다.",
		requiredMode = REQUIRED
	)
	Long totalElements,

	@Schema(
		defaultValue = "false",
		description = "현재 응답하는 페이지가 마지막 일 시, true로 설정됩니다.",
		requiredMode = REQUIRED
	)
	boolean isEnd,

	@Schema(
			description = "응답 데이터 리스트입니다."
	)
	List<T> content
) {

	public static <T> PageableResponse<T> of(Page<T> page) {
		return new PageableResponse<>(
				page.getNumber(),
				page.getSize(),
				page.getTotalPages(),
				page.getTotalElements(),
				page.isLast(),
				page.getContent()
		);
	}
}