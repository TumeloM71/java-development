package com.pluralsight;

public class PalindromeProduct {
    public static void main(String[] args) {

        int biggestPalindrome = 0;
        int product = 0;
        StringBuilder productAsString;
        for (int i = 1; i < 1000; i++){
            for(int j=1; j<1000;j++){
                product = i*j;
                productAsString = new StringBuilder(String.valueOf(product));
                boolean condition = productAsString.toString().equals(productAsString.reverse().toString());
                if(condition){
                    biggestPalindrome = Math.max(product,biggestPalindrome);
                }
            }
        }
        System.out.println("Biggest Palindrome: "+biggestPalindrome);
    }
}
