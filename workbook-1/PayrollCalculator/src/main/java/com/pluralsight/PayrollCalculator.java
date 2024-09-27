package com.pluralsight;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter the amount of hours worked: ");
        float hours = input.nextFloat();
        System.out.print("Enter the hourly pay rate: ");
        float payRate = input.nextFloat();
        float pay = hours * payRate;
        System.out.printf("Your gross pay is $%.2f",pay);

    }
}
