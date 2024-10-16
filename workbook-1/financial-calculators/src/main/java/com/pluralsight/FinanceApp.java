package com.pluralsight;

import java.util.Scanner;
import com.pluralsight.calculators.FutureValueCalculator;
import com.pluralsight.calculators.MortgageCalculator;
import com.pluralsight.calculators.PresentValueOfAnnuityCalculator;

public class FinanceApp {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("The following calculators are available:\n" +
                "1.Mortgage Calculator\n"+
                "2.Future Value Calculator\n" +
                "3.Present Value of an Ordinary Annuity Calculator\n" +
                "Select option 1,2 or 3 by simply typing the respective number.\n");

        //Asks user to choose which application to run and stores the answer in "option"
        int option = userInput.nextInt();

        //Switch statement executes the respective application based on "option"
        switch (option){
            case 1:
                MortgageCalculator.calculate();
                break;
            case 2:
                FutureValueCalculator.calculate();
                break;
            case 3:
                PresentValueOfAnnuityCalculator.calculate();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }

    }
}
