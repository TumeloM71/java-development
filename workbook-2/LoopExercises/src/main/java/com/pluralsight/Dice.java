package com.pluralsight;

public class Dice {
    private static final int maxValue = 6;
    private static final int minValue = 1;

    //Random number in range 1 to 6
    public static int roll(){
        return (int)(Math.random() * maxValue) + minValue;
    }

}
