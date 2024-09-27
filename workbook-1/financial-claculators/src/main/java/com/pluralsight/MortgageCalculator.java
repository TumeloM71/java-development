package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        double principalAmount;// amount that was borrowed
        double annualRate; // annual interest rate as a percentage
        int loanTermInYears; //loan term
        double monthlyPayment;
        double monthlyRate;
        double totalInterest;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the principal ammount");
        principalAmount = input.nextDouble();
        System.out.println("Enter the annual interest rate");
        annualRate = input.nextDouble();
        System.out.println("Enter the loan term in years");
        loanTermInYears = input.nextInt();

    }
    // get the monthly rate needed fot the calculation when given the annualRate as a percentage
    public double getMonthlyInterestRate(double annualRate)
    {
        double rate = annualRate/100;
        return rate/12;
    }
    //gets the loan term in months need for the calculation
    public int getLoanTermInMonths(int termInYears)
    {
        return termInYears*12;
    }
    /*
    Monthly payment is obtained with the following formula:
        m = ( r*P*(1+r)^N )/( (1+r)^N - 1 )

     */
    public double getMonthlyPayment ( double P, int N, double r)
    {
        double m = (r * P * Math.pow(1 + r, N)) / (Math.pow(1 + r, N) - 1);
        return m;


    }
    // Get total interest by subtracting principal from total paid
    public double getTotalInterest( double monthlyPayment, int loanTermInMonths)
    {


    }



}
