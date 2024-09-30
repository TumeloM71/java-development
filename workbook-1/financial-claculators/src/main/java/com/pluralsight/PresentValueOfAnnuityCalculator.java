package com.pluralsight;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class PresentValueOfAnnuityCalculator {

    public static void main() {
        double payAmount;
        int timeInYears;
        double annualRate;
        double monthlyRate;
        double presentValueOfAnnuity;
        //Asking the user for input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the monthly payment amount as a number e.g 1000.50");
        payAmount = input.nextDouble();
        System.out.println("Enter the time period in years as a number e.g 10");
        timeInYears = input.nextInt();
        System.out.println("Enter the annual interest rate as a number e.g 2.5");
        annualRate = input.nextDouble();
        //Getting all the required variables, doing the calculation and then printing the results
        monthlyRate = getMonthlyRate(annualRate);
        presentValueOfAnnuity = getPresentValueOfAnnuity(payAmount,timeInYears,monthlyRate);
        //Added a NumberFormat instance to make the printed out currency more readable with the format method
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("The present value of the ordinary annuity is %s",numberFormat.format(presentValueOfAnnuity));

    }

    public static double getMonthlyRate (double annualRate){
        return annualRate/(100*12);
    }
    /*
    PV = PMT/i * (1 - 1/(1+i)^n where
    PV is the Present Value of an ordinary annuity
    pmt is the monthly pay amount,
    i is the monthly interest rate
    and n is the time period in months
     */
    public static double getPresentValueOfAnnuity(double payAmount, int timeInYears, double monthlyRate){
        int timeInMonths = timeInYears*12;
        double presentValueOfAnnuity = (payAmount/monthlyRate)*(1 - 1/Math.pow(1+monthlyRate, timeInMonths));
        return presentValueOfAnnuity;
    }
    // Overloaded main so I could call it in FinanceApp with having to pass an args array
    public static void main(String[] args) {
        PresentValueOfAnnuityCalculator.main();
    }

}
