package com.thorinhood;

public class Utils {

    public static int randomInRange(int min, int max) {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

}
