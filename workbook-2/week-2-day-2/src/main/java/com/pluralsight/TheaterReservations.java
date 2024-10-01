package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/*
Create a Java application called TheaterReservations. This application is used to
allow customers to reserve tickets for a specific date.
Prompt the user for their full name, the date of the show, and the number of
tickets they will need.
Once the reservation is made, display a confirmation message to the customer in
this format:
# ticket(s) reserved for (date) under (LastName, FirstName)
If only one ticket is reserved, the confirmation should not include an "s"
A sample trace of your program output is shown below. Bolded code is what the
user entered.
Please enter your name: Geri Johnson↵
What date will you be coming (MM/dd/yyyy): 5/13/2023↵
How many tickets would you like? 3↵
3 tickets reserved for 2023-05-13 under Johnson, Geri
A different trace would be:
Please enter your name: Geri Johnson↵
What date will you be coming (MM/dd/yyyy): 5/13/2023↵
How many tickets would you like? 1↵
1 ticket reserved for 2023-05-13 under Johnson, Geri

 */
public class TheaterReservations {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.print("Please enter your name: ");
        String name = input.nextLine().trim();
        String[] nameAsArray = name.split("\\s");
        String firstName = nameAsArray[0];
        String lastName = nameAsArray[nameAsArray.length-1];
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        LocalDate date = LocalDate.parse(input.nextLine().trim(),formatter);
        System.out.print("How many tickets would you like? ");
        int tickets = Integer.parseInt(input.nextLine().trim());

        System.out.printf(tickets+" ticket(s) reserved for "+date+" under "+lastName+", "+firstName);

    }
}
