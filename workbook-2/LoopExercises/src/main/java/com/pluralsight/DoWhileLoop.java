package com.pluralsight;

public class DoWhileLoop {
    public static void main(String[] args) throws InterruptedException
    {
        int count = 1;
        do{
            System.out.println(count+".I love Java.");
            count++;
            Thread.sleep(1000);
        }while( count<=5);
    }
}
