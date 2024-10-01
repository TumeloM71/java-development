package com.pluralsight;

import java.util.Scanner;
import java.util.regex.Pattern;
/*
Create a Java application called FullNameParser that prompts the user to enter a
name in one of the following two formats:
first last or first middle last
Make sure to trim the name before proceeding in case the user entered leading or
trailing spaces.
Parse the name and process it so that you can display the individual pieces of the
name.
A sample trace of your program output is shown below. Bolded code is what the
user entered.
Please enter your name: Dana L. Wyatt ↵
First name: Dana
Middle name: L.
Last name: Wyatt
An different trace would be:
Please enter your name: Dana Wyatt↵
First name: Dana
Middle name: (none)
Last name: Wyatt

 */
public class FullNameParser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = input.nextLine().trim();
        String[] nameArray = name.split(Pattern.quote(" "));
        System.out.println(nameArray.length);
        switch  (nameArray.length){
            case (2):
                System.out.println("First name: "+nameArray[0]+"\nMiddle name: (none)"+"\nLast name: "+nameArray[1]);
                break;
            case (3):
                System.out.println("First name: "+nameArray[0]+"\nMiddle name: "+nameArray[1]+"\nLast name: "+nameArray[2]);
                break;

        }


    }
}
