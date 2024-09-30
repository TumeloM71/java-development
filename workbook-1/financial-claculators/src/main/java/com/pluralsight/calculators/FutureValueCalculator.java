package com.pluralsight.calculators;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FutureValueCalculator {

    public static void calculate() {
        //Declaring the doubles
        double principalValue, annualRate,dailyRate,futureValue,totalInterest;

        //Declaring the integers
        int numOfYears,numOfDays;
        String nameOfItem; // the name of the item/deposit that future value is calculated for

        //Asking the user for input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of your deposit");
        nameOfItem = input.nextLine();
        System.out.println("Enter the principal value of your deposit as a number e.g 1000");
        principalValue = input.nextDouble();
        System.out.println("Enter the annual interest rate as a number e.g 5.5");
        annualRate = input.nextDouble();
        System.out.println("Enter the number of years as a number e.g 7");
        numOfYears = input.nextInt();

        //Getting all the required variables, doing the calculation and then printing the results
        numOfDays = getNumberOfDays(numOfYears);
        dailyRate = getDailyInterestRate(annualRate);
        futureValue = getFutureValue(principalValue,dailyRate,numOfDays);

        //Added a NumberFormat instance to make the printed out currency more readable with the format method
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        totalInterest = futureValue - principalValue;  // totalInterest paid obtained by subtracting principalValue from futureValue
        System.out.printf("The future value of %s is %s and the total interest is %s",nameOfItem,numberFormat.format(futureValue),numberFormat.format(totalInterest));



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
    public static double getFutureValue( double principalValue, double dailyRate, int numOfDays){
        return principalValue*Math.pow(1+dailyRate,numOfDays);
    }

}
