package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    //I decided to overload the main method so I could run it without having to pass an args array in FinanceApp
    public static void main () {
        double principalAmount;// amount that was borrowed
        double annualRate; // annual interest rate as a percentage
        int loanTermInYears; //loan term
        double monthlyPayment;
        double monthlyRate;
        double totalInterest;
        int loanTermInMonths;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the principal ammount");
        principalAmount = input.nextDouble();
        System.out.println("Enter the annual interest rate");
        annualRate = input.nextDouble();
        System.out.println("Enter the loan term in years");
        loanTermInYears = input.nextInt();

        monthlyRate = getMonthlyInterestRate(annualRate);
        loanTermInMonths = getLoanTermInMonths(loanTermInYears);
        monthlyPayment = getMonthlyPayment(principalAmount, loanTermInMonths, monthlyRate);
        totalInterest = getTotalInterest( monthlyPayment,loanTermInMonths,principalAmount);

        System.out.printf("Your monthly payment is $%.2f%n",monthlyPayment);
        System.out.printf("Your total interest is $%.2f%n",totalInterest);


    }
    // get the monthly rate needed fot the calculation when given the annualRate as a percentage
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
        double m = (r * P * Math.pow(1 + r, N)) / (Math.pow(1 + r, N) - 1);
        return m;


    }
    // Get total interest by subtracting principal from total paid
    public static double getTotalInterest( double monthlyPayment, int loanTermInMonths, double Principal)
    {
        double totalPaid = monthlyPayment * loanTermInMonths;
        double totalInterest = totalPaid - Principal;
        return totalInterest;

    }
    //This simply calls the version of main without arguments
    public static void main(String[] args) {
        MortgageCalculator.main();
    }


}
