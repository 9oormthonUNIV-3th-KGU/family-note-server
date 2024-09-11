package goorm.kgu.familynote.common.util;

import java.util.Random;

public class RandomNumberUtils {

    public static Long getRandomLongInRange(Long max) {
        Random random = new Random();
        return random.nextLong(max) + 1;
    }

}
