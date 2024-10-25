package com.pluralsight;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner input ;
    private Dealership dealership;

    public UserInterface() throws IOException {
        this.setInput(new Scanner(System.in));
        this.setDealership(DealershipFileManager.getDealership());
    }

    private void init() throws IOException {

    }

    public void display() throws IOException {
        System.out.println("Welcome to "+this.dealership.toString().split("\\|")[0]);
        int selection;

        while (true) {
            System.out.println("Select an option by pressing the respective number");
            System.out.println("1.Get vehicles by price");
            System.out.println("2.Get vehicles by make & model");
            System.out.println("3.Get vehicles by release year");
            System.out.println("4.Get vehicles by color");
            System.out.println("5.Get vehicles by type");
            System.out.println("6.Get all vehicles");
            System.out.println("7.Add a vehicle");
            System.out.println("8.Remove a vehicle");
            System.out.println("0.Exit");

            selection = Utilities.getIntValue(input.nextLine().trim());

            switch (selection){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeAndModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByVehicleTypeRequest();
                    break;
                case 6:
                    processGetAllVehiclesRequest();
                    break;
                case 7:
                    processAddVehicleRequest();
                    break;
                case 8:
                    processRemoveVehicleRequest();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private void processGetByPriceRequest(){
        System.out.print("Enter the minimum price: ");
        int min = Utilities.getIntValue(input.nextLine().trim());
        System.out.print("Enter the maximum price: ");
        int max = Utilities.getIntValue(input.nextLine().trim());
        displayVehicles(dealership.getVehiclesByPrice(min,max));
    }

    private void processGetByMakeAndModelRequest(){
        System.out.print("Enter the make: ");
        String make = input.nextLine().trim();
        System.out.print("Enter the model: ");
        String model = input.nextLine().trim();
        displayVehicles(dealership.getVehiclesByMakeModel(make,model));
    }

    private void processGetByYearRequest(){
        System.out.print("Enter the year minimum: ");
        int min = Utilities.getIntValue(input.nextLine().trim());
        System.out.print("Enter the year maximum: ");
        int max = Utilities.getIntValue(input.nextLine().trim());
        displayVehicles(dealership.getVehiclesByYear(min,max));
    }

    private void processGetByColorRequest(){
        System.out.print("Enter the color: ");
        String color = input.nextLine().trim();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByVehicleTypeRequest(){
        System.out.print("Enter the vehicle type: ");
        String type = input.nextLine().trim();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processGetByMileageRequest(){
        System.out.print("Enter the minimum mileage: ");
        int min = Utilities.getIntValue(input.nextLine().trim());
        System.out.print("Enter the maximum mileage: ");
        int max = Utilities.getIntValue(input.nextLine().trim());
        displayVehicles(dealership.getVehiclesByMileage(min,max));

    }

    private void processGetAllVehiclesRequest(){
        displayVehicles(this.dealership.getAllVehicles());
    }
    public void processAddVehicleRequest() throws IOException {
        System.out.println("Enter the details in this format:\n"+
                "vin|year|make|model|type|color|mileage|price");
        String line = input.nextLine().trim();
        this.dealership.addVehicle(new Vehicle(line));
        DealershipFileManager.saveDealearship(this.dealership);
    }

    public void processRemoveVehicleRequest() throws IOException {
        System.out.println("Enter the details in this format:\n" +
                "vin|year|make|model|type|color|mileage|price");
        String line = input.nextLine().trim();
        this.dealership.removeVehicle(new Vehicle(line));
        DealershipFileManager.saveDealearship(this.dealership);
    }

    public void displayVehicles(List<Vehicle> vehicles){
        System.out.println("Vehicles: ");
        for (Vehicle v : vehicles)
            System.out.println(v);
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }
}
