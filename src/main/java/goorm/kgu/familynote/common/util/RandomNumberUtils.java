package goorm.kgu.familynote.common.util;

import java.util.Random;

public class RandomNumberUtils {

    public static Integer getRandomIntInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)) + min;
    }

}
