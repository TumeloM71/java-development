package com.pluralsight;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        /*
        Enter the first number: 5
        Enter the second number: 12
        Possible calculations:
        (A)dd
        (S)ubtract
        (M)ultiply
        (D)ivide
        Please select an option: M
        5 * 12 = 6
         */

        printToScreen();
        printToScreen();
        printToScreen();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number:");
        float num1 = input.nextFloat();
        System.out.print("Enter the second number:");
        float num2 = input.nextFloat();
        System.out.println("Possible calculations: \n" +
                "(A)dd\n" +
                "(S)ubtract\n" +
                "(M)ultiply\n" +
                "(D)ivide");
        System.out.print("Please select an option:");
        input.nextLine();  //Consume the CRLF to get the next line input properly
        String option = input.nextLine();

        switch (option){
            case ("A"):
                float sum = add( num1, num2 );
                System.out.printf("%.4f + %.4f = %.4f%n",num1, num2, sum );
                break;
            case ("S"):
                float diff  = num1-num2;
                System.out.printf("%.4f - %.4f = %.4f%n",num1, num2, diff );
                break;
            case ("M"):
                float product = multiply( num1,num2 );
                System.out.printf("%.4f * %.4f = %.4f%n",num1, num2, product );
                break;
            case ("D"):
                float quotient = num1/num2;
                System.out.printf("%.4f / %.4f = %.4f%n",num1, num2, quotient );
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }

    }
    public static float add(float numOne, float numTwo)
    {
        return numOne+numTwo;
    }
    public static void printToScreen()
    {
        System.out.println("Hello World!");
    }
    public static float multiply(float numOne, float numTwo)
    {
        return numOne*numTwo;
    }

}
