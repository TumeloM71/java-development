package com.pluralsight;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner input ;
    static Dealership dealership;

    private UserInterface() {
    }

    private static void init() throws IOException {
        input = new Scanner(System.in);
        dealership = DealershipFileManager.getDealership();
    }

    public static void display() throws IOException {
        init();

        System.out.println("Welcome to "+dealership.toString().split("\\|")[0]);
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

            selection = Utilities.getIntValue(input.nextLine().trim());

            switch (selection){}
        }
    }

    private void processGetByPriceRequest(){
        System.out.println();
    }

    private void processGetByMakeAndModelRequest(){}

    private void processGetByYearRequest(){}

    private void processGetByColorRequest(){}

    private void processGetByVehicleTypeRequest(){}

    private void processGetByMileageRequest(){}

    private void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest(){}

    public void processRemoveVehicleRequest(){}

    public void displayVehicles(List<Vehicle> vehicles){
        System.out.println("Vehicles: ");
        for (Vehicle v : vehicles)
            System.out.println(v);
    }
}
