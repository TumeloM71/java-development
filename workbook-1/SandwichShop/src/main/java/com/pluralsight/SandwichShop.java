package com.pluralsight;
import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1: Regular: base price $5.45\n" +"2: Large: base price $8.95");
        /*
        Prompt the user for the size of the sandwich (1 or 2):
        - 1: Regular: base price $5.45
        - 2: Large: base price $8.95
         */
        System.out.println("Which size do you want?");
        String sizeChoice = input.nextLine();
        double baseCost;
        if (sizeChoice.equalsIgnoreCase("Regular") )
            baseCost = 5.45;
        else if(sizeChoice.equalsIgnoreCase("Large") )
            baseCost = 8.95;
        else
            throw new IllegalArgumentException("Unexpected value "+sizeChoice);
        /*
        Prompt the user for their age:
        - Student (17 years old or younger) — receive a 10% discount
        - Seniors (65 years old or older) — receive a 20% discount
         */
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        if (age <= 17)
            System.out.println("Congrats!You've received a 10% student discount. Cost : $"+0.9*baseCost);
        else if (age >= 65)
            System.out.println("Congrats!You've received a 20% senior discount. Cost : $"+0.8*baseCost);
        else
            System.out.println("Cost : $"+baseCost);


    }
}



