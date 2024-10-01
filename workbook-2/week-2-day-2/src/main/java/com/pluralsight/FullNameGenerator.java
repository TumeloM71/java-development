package com.pluralsight;

import java.util.Scanner;
/*
Create a Java application called FullNameGenerator. Ensure that you set the
GroupId to com.pluralsight. Create a new package named
com.pluralsight and add a new class called FullNameApplication for the
main() method.
You will prompt the user to enter the parts of their name. You will then create a
new string that holds the users full name.
The user will always have a first and last name, they may also have a middle
name and a suffix (ex. Jr, PhD). If a user does not enter a value for the middle
name or suffix, the full name should not include that part of the name. If the user
has a suffix in their name, the full name should include a comma before the
suffix.
Glen Williams
Glen C. Williams
Glen Williams, PhD
Glen C. Williams, PhD
Make sure to trim any leading or trailing spaces that the user may have entered.
Note: the ↵ represents the user hiting the ENTER key
Please enter your name
First name: Glen↵
Middle name: ↵
Last name: Williams↵
Suffix: ↵
Full name: Glen Williams

 */
public class FullNameGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Getting user input
        System.out.print("Please enter your name\nFirst name: ");
        String firstname = input.nextLine().trim();
        System.out.print("Middle name: ");
        String middleName = input.nextLine().trim();
        System.out.print("Last name: ");
        String lastName = input.nextLine().trim();
        System.out.print("Suffix: ");
        String suffix = input.nextLine().trim();
        System.out.println();
        /*Conditional for this truth table
           middleName.isEmpty suffix.IsEmpty
                   True               True
                   True               False
                   False              True
                   False              False
          Output is printed accordingly
         */

        if (middleName.isEmpty() && suffix.isEmpty())
            System.out.printf("Fullname: %s %s",firstname, lastName);
        else if (middleName.isEmpty() )
            System.out.printf("Fullname: %s %s %s",firstname,lastName,suffix);
        else if(suffix.isEmpty())
            System.out.printf("Fullname: %s %s %s",firstname,middleName,lastName);
        else
            System.out.printf("Fullname: %s %s %s %s",firstname,middleName,lastName,suffix);
    }

}
