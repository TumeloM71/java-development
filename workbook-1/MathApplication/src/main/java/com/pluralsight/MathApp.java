/*
Author: Tumelo Marongwe
Workbook 1, Intro to Java Exercise 2
*/
package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        /*Question 1
        * 1. Create two variables to represent the salary for Bob and Gary, name them
            bobSalary and garySalary. Create a new variable named
            highestSalary. Determine whose salary is greater using Math.max() and
            store the answer in highestSalary. Set the initial salary variables to any value
            you want. Print the answer (i.e "The highest salary is ...")
        * */

        int bobSalary = 75_000;
        int  garySalary = 100_000;
        int answer = Math.max(bobSalary,garySalary);
        System.out.printf("1. Higher salary = %d\n",answer); // Math.max used to get the higher value
        /*2. Find and display the smallest of two variables
             named carPrice and truckPrice. Set the variables to any value you want.
         */
        double carPrice = 34_399.99;
        double truckPrice = 135_999.99;
        System.out.printf("2. Lower price = %.2f\n",Math.min(carPrice,truckPrice)); //Math.min used to get lower price
        /*
        3. Find and display the area of a circle whose radius is 7.25
         */
        float radius = 7.25f;
        System.out.printf("3. Area(to 2 decimal places) = %.2f\n", Math.PI * Math.pow(radius, 2) ); //Area of a circle = PI*radius^2
        /*
        4. Find and display the square root a variable after it is set to 5.0
         */
        double squaredNumber = 5.0;
        System.out.printf("4. Square root (to 2 decimal places) = %.2f\n", Math.sqrt(squaredNumber)); //sqrt function is used to obtain the square root
        /*
        5. Find and display the distance between the points (5, 10) and (85, 50)
         */
        Vector2D v1 = new Vector2D(5, 10); //Vector 2D class is used to make 2D vectors from the two points' x and y values. Credit to gunvirranu on Github for writing the class
        Vector2D v2 = new Vector2D(85, 50);
        double distance = Math.sqrt(v1.distanceSq(v2));  //The distanceSq method from Vector2D return the distance squared between two points on a 2D plane. Square root of that value is the answer.
        System.out.printf("5. The distance between the two points(to 2 decimal places) is %.2f\n",distance);
        /*
        6. Find and display the absolute (positive) value of a variable after it is set to -3.8
         */
        double value = -3.8;
        System.out.println("6. The absolute value is "+Math.abs(value));// Math.abs() method is used for the absolute value
        /*
        7. Find and display a random number between 0 and 1
         */
        double random = Math.random();
        System.out.println("7. The random number is "+random); //Math.random() returns a decimal number in the range 0 to 1



    }
}
