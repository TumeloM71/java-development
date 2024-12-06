package com.pluralsight;

import com.pluralsight.datamanagers.VehiclesDAO;
import com.pluralsight.models.Vehicle;


import java.util.List;
import java.util.Scanner;


public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        VehiclesDAO vehiclesManager = new VehiclesDAO(args[0], args[1]);

        boolean loopFlag = true;

        try {
            while (loopFlag) {
                System.out.println();
                System.out.print("What do you want to do?\n" +
                        "1) Get cars by price range\n" +
                        "2) Get cars by make\n" +
                        "3) Get cars by make & model\n" +
                        "4) Get cars by release year\n" +
                        "5) Get cars by mileage range\n" +
                        "6) Get cars by color\n" +
                        "7) Get cars by type\n" +
                        "0) Exit\n" +
                        "Select an option: ");

                int selection = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                switch (selection) {
                    case 1 -> getByPriceRange(vehiclesManager);
                    case 2 -> getByMake(vehiclesManager);
                    case 3 -> getByMakeModel(vehiclesManager);
                    case 4 -> getByYearRange(vehiclesManager);
                    case 5 -> getByMileageRange(vehiclesManager);
                    case 6 -> getByColor(vehiclesManager);
                    case 7 -> getByType(vehiclesManager);
                    case 0 -> loopFlag = false;
                    default -> System.out.println("Invalid input. Try again");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            System.exit(0);
        }

    }

    public static void getByPriceRange(VehiclesDAO vehicleManager){

        double min = askForDouble("min");
        double max = askForDouble("max");
        List<Vehicle> vehicles = vehicleManager.getByPriceRange(min,max);
        vehicles.forEach(System.out::println);
    }

    public static void getByYearRange(VehiclesDAO vehicleManager){

        int min = askForInt("min");
        int max = askForInt("max");
        List<Vehicle> vehicles = vehicleManager.getByYearRange(min,max);
        vehicles.forEach(System.out::println);
    }

    public static void getByMileageRange(VehiclesDAO vehiclesDAO){

        int min = askForInt("min");
        int max = askForInt("max");
        List<Vehicle> vehicles = vehiclesDAO.getByYearRange(min,max);
        vehicles.forEach(System.out::println);
    }

    public static void getByMake(VehiclesDAO vehiclesDAO){

        String make = askForMake();
        List<Vehicle> vehicles = vehiclesDAO.getByMake(make);
        vehicles.forEach(System.out::println);
    }

    public static void getByMakeModel(VehiclesDAO vehiclesDAO){

        String make = askForMake();
        String model = askForModel();
        List<Vehicle> vehicles = vehiclesDAO.getByMakeModel(make, model);
        vehicles.forEach(System.out::println);
    }

    public static void getByColor(VehiclesDAO vehiclesDAO){

        String color = askForColor();
        List<Vehicle> vehicles = vehiclesDAO.getByColor(color);
        vehicles.forEach(System.out::println);
    }

    public static void getByType(VehiclesDAO vehiclesDAO){
        String type = askForType();
        List<Vehicle> vehicles = vehiclesDAO.getByType(type);
        vehicles.forEach(System.out::println);
    }

    public static String askForMake(){

        System.out.println("Enter the make");
        return scanner.nextLine();
    }

    public static String askForModel(){

        System.out.println("Enter the model");
        return scanner.nextLine();
    }

    public static String askForColor(){

        System.out.println("Enter the color");
        return scanner.nextLine();
    }

    public static String askForType(){

        System.out.println("Enter the type");
        return scanner.nextLine();
    }

    public static double askForDouble(String minOrMax){

        if (minOrMax.equalsIgnoreCase("min"))
        {
            System.out.print("Enter the minimum : ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            return price;
        }
        else {
            System.out.print("Enter the maximum : ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            return price;
        }
    }

    public static int askForInt(String minOrMax){
        if (minOrMax.equalsIgnoreCase("min"))
        {
            System.out.print("Enter the minimum: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            return year;
        }
        else{
            System.out.print("Enter the maximum: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            return year;
        }
    }
}
