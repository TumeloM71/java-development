package com.pluralsight;

import java.util.Scanner;

/*
Create a new project called CellPhoneService. Add a package
com.pluralsight.
Step 1
Add a class named CellPhoneApplication and add the main() method.
Create a class named CellPhone. The class should have the following data
members:
- serialNumber (ex: 1000000 - 9999999)
- model (ex: iPhone X)
- carrier (ex: AT&T)
- phoneNumber (ex: 800-555-5555)
- owner (ex: Dana Wyatt)
Add a parameterless constructor. Provide the following default values for all
string data types in the constructor.
- serialNumber = 0
- model = ""
- carrier = ""
- phoneNumber = ""
- owner = ""
Provide getter and setter methods for all 5 data members.

Step 2
Verify that your class is built correctly by creating a new instance of a
CellPhone in your CellPhoneApp.main() method.
Create a new instance of a CellPhone, then prompt the user for the cell phone
information:
What is the serial number? 2597153
What model is the phone? iPhone 15 Pro Max
Who is the carrier? Verizon
What is the phone number? 888-555-1234
Who is the owner of the phone? Sandra
Use the setters of your CellPhone object to add the values entered by the user.
Using the getters of the CellPhone print the properties of the phone to the
screen.
Step 3
Stage, commit and push your changes to GitHub.

 */
public class CellPhoneService {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        CellPhone phone = new CellPhone();
        CellPhone phone2 = new CellPhone();

        //Getting user input
        System.out.print("What is the serial number? ");
        phone.setSerialNumber(input.nextInt());
        System.out.print("What model is the phone? ");
        input.nextLine();
        phone.setModel(input.nextLine());
        System.out.print("Who is the carrier? ");
        phone.setCarrier(input.nextLine());
        System.out.print("What is the phone number? ");
        phone.setPhoneNumber(input.nextLine());
        System.out.print("Who is the owner of the phone? ");
        phone.setOwner(input.nextLine());
        System.out.println()//Empty line to make spacing

        ;
        System.out.print("What is the serial number? ");
        phone2.setSerialNumber(input.nextInt());
        System.out.print("What model is the phone? ");
        input.nextLine();
        phone2.setModel(input.nextLine());
        System.out.print("Who is the carrier? ");
        phone2.setCarrier(input.nextLine());
        System.out.print("What is the phone number? ");
        phone2.setPhoneNumber(input.nextLine());
        System.out.print("Who is the owner of the phone? ");
        phone2.setOwner(input.nextLine());
        System.out.println();//Empty line to make spacing

        //Printing instance variables to screen
        display(phone);
        display(phone2);

        //Dial method
        phone.dial(phone2.getPhoneNumber());
    }

    public static void display (CellPhone phone){
        System.out.println("Serial number: "+phone.getSerialNumber());
        System.out.println("Model: "+phone.getModel());
        System.out.println("Carrier: "+phone.getCarrier());
        System.out.println("Phone Number: "+phone.getPhoneNumber());
        System.out.println("Owner: "+phone.getOwner());
        System.out.println(); //Empty line to make spacing

    }
}
