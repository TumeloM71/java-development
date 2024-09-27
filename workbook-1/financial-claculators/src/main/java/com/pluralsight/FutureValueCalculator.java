package com.pluralsight;

import java.util.Scanner;

public class FutureValueCalculator {
    public static void main(String[] args) {
        double principalValue;
        double annualRate;  //this is the annual rate as a percentage
        int numOfYears; //  the number of years used in the future value calculation
        double dailyRate;
        double numOfDays;
        String nameOfItem; // the name of the item that future value is calculated for

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the principal value of your item");
        principalValue = input.nextDouble();
        System.out.println("Enter the annual interest rate");
        annualRate = input.nextDouble();
        System.out.println("Enter the number of years");
        numOfYears = input.nextInt();

    }
    //The question said daily compounding is used so we have to get the Daily Interest Rate
    public static double getDailyInterestRate(double annualRate) {
        return annualRate/(100*365);  // turn the percentage to a rate by dividing by 100 and then get daily rate by dividing by 365
    }
    //We also need the total number of days since daily compounding is used
    public static int getNumberOfDays(int numOfYears) {
        return numOfYears*365;
    }
    // Future Value(FV) = PV*(1+i)^n where PV is principalValue, i is the interestRate and n is the number of terms
    public double getFutureValue( double principalValue, double dailyRate, int numOfDays){
        double futureValue = principalValue*Math.pow(1+dailyRate,numOfDays);
        return futureValue;
    }
}
