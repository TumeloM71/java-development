package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Scanner;

public class Northwind_Exercise4 {

    static String userName = null;
    static String password = null;
    static Scanner scanner;
    static BasicDataSource dataSource;

    public static void main(String[] args) {

        userName = args[0];
        password = args[1];
        scanner = new Scanner(System.in);

        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        boolean loopFlag = true;
        try {
            while (loopFlag) {
                System.out.print("What do you want to do?\n" +
                        "1) Display all products\n" +
                        "2) Display all customers\n" +
                        "3) Display all categories\n" +
                        "0) Exit\n" +
                        "Select an option: ");

                int selection = scanner.nextInt();
                scanner.nextLine();

                switch (selection) {
                    case 1 -> displayProducts();
                    case 2 -> displayCustomers();
                    case 3 -> displayAllCategories();
                    case 0 -> loopFlag = false;
                    default -> System.out.println("Invalid input. Try again");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayProductsInCategory(String CategoryID) throws ClassNotFoundException {

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM northwind.products" +
                        " WHERE CategoryID = ?");

        ) {
            statement.setString(1, CategoryID);
            displayResults(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllCategories() throws ClassNotFoundException {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT CategoryID, CategoryName, Description FROM northwind.categories");
        ) {

            displayResults(statement);
            System.out.println("Enter a CategoryID to see all the products in that Category:");
            String CategoryID = scanner.nextLine().trim();
            displayProductsInCategory(CategoryID);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void displayCustomers() throws ClassNotFoundException {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT CompanyName, ContactName, ContactTitle, City, Country, Phone FROM northwind.customers;")
        ) {
            displayResults(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void displayProducts() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM northwind.products" +
                        " ORDER BY ProductName")
        ) {
            displayResults(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayResults(PreparedStatement statement) {
        try (ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
                    System.out.print(results.getMetaData().getColumnLabel(i) + " : ");
                    System.out.print(results.getString(i) + "\n");
                }
                System.out.println("---".repeat(80));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
