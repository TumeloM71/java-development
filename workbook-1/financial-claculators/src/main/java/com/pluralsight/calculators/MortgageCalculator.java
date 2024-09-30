package com.pluralsight.calculators;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {

    public static void calculate () {
        //Declaring the doubles
        double principalAmount,monthlyPayment,monthlyRate,totalInterest,annualRate;//

        //Declaring the integers
        int loanTermInYears,loanTermInMonths;

        //Asking the user for input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the principal ammount as a number e.g 2050.99");
        principalAmount = input.nextDouble();
        System.out.println("Enter the annual interest rate as number e.g 7.5");
        annualRate = input.nextDouble();
        System.out.println("Enter the loan term in years as a number e.g 15");
        loanTermInYears = input.nextInt();

        //Getting all the required variables, doing the calculation and then printing the results
        monthlyRate = getMonthlyInterestRate(annualRate);
        loanTermInMonths = getLoanTermInMonths(loanTermInYears);
        monthlyPayment = getMonthlyPayment(principalAmount, loanTermInMonths, monthlyRate);
        totalInterest = getTotalInterest( monthlyPayment,loanTermInMonths,principalAmount);

        //Added a NumberFormat instance to make the printed out currency more readable with the format method
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Your monthly payment is %s%n",numberFormat.format(monthlyPayment));
        System.out.printf("Your total interest is %s%n",numberFormat.format(totalInterest));


    }

    // get the monthly interest rate needed fot the calculation when given the annualRate as a percentage
    public static double getMonthlyInterestRate(double annualRate)
    {
        double rate = annualRate/100;
        return rate/12;
    }

    //gets the loan term in months need for the calculation
    public static int getLoanTermInMonths(int termInYears)
    {
        return termInYears*12;
    }

    /*
    Monthly payment is obtained with the following formula:
        m = ( r*P*(1+r)^N )/( (1+r)^N - 1 )

     */
    public static double getMonthlyPayment ( double P, int N, double r)
    {
        return (r * P * Math.pow(1 + r, N)) / (Math.pow(1 + r, N) - 1);


    }

    // Get total interest by subtracting principal from total paid
    public static double getTotalInterest( double monthlyPayment, int loanTermInMonths, double Principal)
    {
        double totalPaid = monthlyPayment * loanTermInMonths;
        return totalPaid - Principal;

    }

}
