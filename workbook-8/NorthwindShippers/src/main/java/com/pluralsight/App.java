package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class App {

    static Scanner scanner ;
    public static void main(String[] args) {

        String userName = args[0];
        String password = args[1];
        scanner = new Scanner(System.in);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        DataManager.setDataSource(dataSource);

        boolean loopFlag = true;

        try {
            while (loopFlag) {
                System.out.println();
                System.out.print("What do you want to do?\n" +
                        "1) Add a new shipper\n" +
                        "2) Display shippers\n" +
                        "3) Update shipper name\n" +
                        "4) Update shipper phone\n" +
                        "5) Delete shipper\n" +
                        "0) Exit\n" +
                        "Select an option: ");

                int selection = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                switch (selection) {
                    case 1 -> addNewShipper();
                    case 2 -> displayShippers();
                    case 3 -> updateShipperName();
                    case 4 -> updateShipperPhone();
                    case 5 -> deleteShipper();
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

    public static void displayShippers(){
        DataManager.displayShippers();
    }

    public static void addNewShipper(){
        DataManager.addShipper(askForCompanyName(), askForPhoneNumber());
    }

    public static void updateShipperName(){
        DataManager.updateShipperName(askForShipperId(), askForCompanyName());
    }

    public static void updateShipperPhone(){
        DataManager.updateShipperPhone(askForShipperId(), askForPhoneNumber());
    }

    public static void deleteShipper(){
        DataManager.deleteShipper(askForShipperId());
    }

    public static int askForShipperId(){
        System.out.println("What is the shipper Id?");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public static String askForCompanyName(){
        System.out.println("What is the company name ?");
        return scanner.nextLine().trim();
    }

    public static String askForPhoneNumber(){
        System.out.println("What it the phone number ?");
        return scanner.nextLine().trim();
    }
}
