package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Northwind_Exercise3 {

    static ResultSet results = null;
    static PreparedStatement statement = null;
    static Connection connection = null;
    static String userName = null;
    static String password = null;
    static Scanner scanner;

    public static void main(String[] args) {

        userName = args[0];
        password = args[1];
        scanner = new Scanner(System.in);

        boolean loopFlag = true;
        try {
            while (loopFlag) {
                System.out.print("What do you want to do?\n" +
                        "1) Display all products\n" +
                        "2) Display all customers\n" +
                        "0) Exit\n" +
                        "Select an option: ");

                int selection = scanner.nextInt();

                switch (selection) {
                    case 1 -> displayProducts();
                    case 2 -> displayCustomers();
                    case 0 -> loopFlag = false;
                    default -> System.out.println("Invalid input. Try again");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Inside finally block.");
            if(results!=null) {
                try {
                    results.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                   e.printStackTrace();
                }
            }
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.exit(0);
        }
    }

    public static void displayCustomers() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                userName,
                password);

        statement = connection.prepareStatement("SELECT CompanyName, ContactName, ContactTitle, City, Country, Phone FROM northwind.customers;");
        results = statement.executeQuery();

        while (results.next()) {
            for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
                System.out.print(results.getMetaData().getColumnLabel(i) + " : ");
                System.out.print(results.getString(i) + "\n");
            }
            System.out.println("---".repeat(80));
        }

    }

    public static void displayProducts() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                userName,
                password);

        statement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM northwind.products" +
                " ORDER BY ProductName");

        results = statement.executeQuery();

        while (results.next()) {
            for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
                System.out.print(results.getMetaData().getColumnLabel(i) + " : ");
                System.out.print(results.getString(i) + "\n");
            }
            System.out.println("---".repeat(80));
        }

    }
}
