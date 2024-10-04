package com.pluralsight;

public class WhileLoop {

    public static void main(String[] args) throws InterruptedException {
        int count = 1;

        while (count <= 5) {
            System.out.println(count+".I love Java.");
            count++;
            Thread.sleep(1000);
        }
    }
}

