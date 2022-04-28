package com.globant.data;

import java.util.Random;

public class Utilities {
    private static Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(5 + 0) + 0;
    }
}
