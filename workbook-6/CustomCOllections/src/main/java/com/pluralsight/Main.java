package com.pluralsight;

public class Main {

    public static void main(String[] args) {

        FixedList<Integer> integers = new FixedList<>(3);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        System.out.println(integers);

        FixedList<String> strings = new FixedList<>(3);
        strings.add("Aa");
        strings.add("Bb");
        strings.add("Cc");
        strings.add("Dd");

        System.out.println(strings);

    }
}
