package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

/*
EXERCISE 4
Step 1
Create a Java application called VehicleInventory. This application is intended to
manage the inventory for a used car dealership. Users will use a menu to lookup
vehicles or add vehicles to the list.
Create a class named Vehicle. Add the following data members to it:
vehicleId - a long (ex: 101121)
makeModel - a string (ex: Ford Explorer)
color - a string (ex: Red)
odometerReading - an int (ex: 32775)
price - a float (ex: 12250.00) (no Lamborghinis here!)
Add a constructor and get/set methods for each property of the car.

Back in main(), create an array capable of holding up to 20 vehicles and a
counter variable that tells you how many vehicles are in the array right now.
Preload the array with 6 vehicles:
vehicleId,makeModel,color,odometerReading,price
101121,Ford Explorer,Red,45000,13500
101122,Toyota Camry,Blue,60000,11000
101123,Chevrolet Malibu,Black,50000,9700
101124,Honda Civic,White,70000,7500
101125,Subaru Outback,Green,55000,14500
101126,Jeep Wrangler,Yellow,30000,16000
Create a loop and prompt the user for a command within the loop. The code the
user sees should be:
What do you want to do?
1 - List all vehicles
2 - Search by make/model
3 - Search by price range
4 - Search by color
5 - Add a vehicle
6 - Quit
Enter your command:
You may not get all options in the command list done.
Begin with options 1, 2 and 5. Once you've completed those options, add logic to
allow the user to search for a vehicle by price or color.
3
Use methods wisely. It seems like your loop could match a command to a
number and then call a method to do the processing. For example:
System.out.println("What do you want to do?");
System.out.println(" 1 - List all vehicles");
System.out.println(" 2 - Search by make/model");
System.out.println(" 3 - Search by price range");
System.out.println(" 4 - Search by color");
System.out.println(" 5 - Add a vehicle");
System.out.println(" 6 - Quit");
System.out.println("Enter your command: ");
int command = scanner.nextInt();
switch(command) {
    case 1:
    listAllVehicles();
    break;
    case 2:
    findVehiclesByPrice();
    break;
    case 5:
    addAVehicle();
    break;
    case 6:
    return;
}
S
 */
public class VehicleInventory {

    private static int vehicleCount;

    public static void main(String[] args) {

        Vehicle[] cars = new Vehicle[20];
        cars[0] = new Vehicle(101121,"Ford Explorer","Red",45000,13500);
        cars[1] = new Vehicle(101122,"Toyota Camry","Blue",60000,11000);
        cars[2] = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        cars[3] = new Vehicle(101124,"Honda Civic","White",70000,7500);
        cars[4] = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        cars[5] = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);
        vehicleCount = 6;
        Scanner input = new Scanner(System.in);
        int command = 0;

        do {
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.println();
            command = input.nextInt();

            switch(command) {
                case 1:
                    listAllVehicles(cars);
                    break;
                case 2:
                    findVehiclesByModel(cars);
                    break;
                case 3:
                    findByPriceRange(cars);
                    break;
                case 4:
                    findVehiclesColor(cars);
                    break;
                case 5:
                    addAVehicle(cars);
                    break;
                case 6:
                    return;
        }
    }while(command != 6);
}

public static void listAllVehicles( Vehicle[] cars){
    for (int i=0; i<vehicleCount; i++)
        System.out.println(cars[i].toString());

    System.out.println();
    }

public static void findVehiclesByModel(Vehicle[] cars){
    Scanner input  = new Scanner(System.in) ;
    System.out.println("Enter the make/model you're looking for");
    String model = input.nextLine().trim();
    int i = 0;
    boolean vehicleFound = false;
    while (!vehicleFound && i<vehicleCount){

        vehicleFound = cars[i].getMakeModel().equals(model);
        i++;
    }
    if (vehicleFound == true) {
        System.out.println("Vehicle found: "+cars[i-1].toString());
    }
    else {
        System.out.println("Vehicle not found");
    }
    System.out.println();
}

    public static void findVehiclesColor(Vehicle[] cars){

        Scanner input  = new Scanner(System.in) ;
        System.out.println("Enter the color you're looking for");
        String color = input.nextLine().trim();
        int i ;
        boolean vehicleFound = false;

       for (i=0; i<vehicleCount; i++){
            if (cars[i].getColor().equals(color))
                System.out.println(cars[i].getColor()+" "+cars[i].getMakeModel());
                vehicleFound = true;
        }
        if (!vehicleFound) {
            System.out.println("Vehicle not found.");
        }
        System.out.println();
    }
    public static void findByPriceRange(Vehicle[] cars){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the minimum: ");
        double min = input.nextDouble();
        System.out.print("Enter the maximum: ");
        double max = input.nextDouble();
        boolean vehicleFound = false;
        for (int i=0; i<vehicleCount; i++){
            if (cars[i].getPrice()<=max && cars[i].getPrice()>=min) {
                System.out.println(cars[i].toString());
                vehicleFound = true;
            }
        }
        if (!vehicleFound)
            System.out.println("Not found");
        System.out.println();
    }

public static void addAVehicle(Vehicle[] cars){
     if(vehicleCount != 20) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the vehicleID: ");
        long vehicleID = input.nextLong();
        System.out.println("Enter the make/model: ");
        input.nextLine();
        String model  = input.nextLine();
        System.out.println("Enter the color: ");
        String color = input.nextLine();
        System.out.println("Enter the odometer reading: ");
        int odometerReading = input.nextInt();
        System.out.println("Enter the price: ");
        double price = input.nextDouble();
        Vehicle newCar = new Vehicle(vehicleID,model,color,odometerReading,price);
        cars[vehicleCount++] = newCar;
        System.out.println("Car Added"); }
     else
         System.out.println("Inventory is full. Vehicle could not be added");
    System.out.println();

}
}