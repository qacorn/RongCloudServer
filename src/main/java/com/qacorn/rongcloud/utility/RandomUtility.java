package com.qacorn.rongcloud.utility;

import java.util.Random;

public class RandomUtility {

    private static Random random = new Random();

    public static Long generateRandomId(Integer idLength) {
        if (idLength < 8 || idLength > 16) {
            return -1L;
        }
        if (idLength > 8) {
            return generateRandomId(idLength - 8)*100000000 + random.nextInt(100000000);
        }
        Integer max = 1;
        for (int i = 0; i < (idLength - 1); i++) {
            max *= 10;
        }
        return random.nextInt(max * 9) + max.longValue();
    }

    public static <T> Long generateRandomId(Integer idLength, T argument, IdChecker<T> idChecker) {
        return generateRandomId(idLength, 10, argument, idChecker);
    }

    public static <T> Long generateRandomId(Integer idLength, Integer tryTimes, T argument, IdChecker<T> idChecker) {
        for (Integer i = 0; i < tryTimes; i++) {
            Long id = generateRandomId(idLength);
            try {
                Boolean valid = idChecker.tryId(id, argument);
                if (valid) {
                    return id;
                }
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        return null;
    }
}
