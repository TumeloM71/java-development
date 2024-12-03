package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    static String userName = null;
    static String password = null;
    static Scanner scanner;
    static BasicDataSource dataSource;

    public static void main(String[] args) {

        userName = args[0];
        password = args[1];
        scanner = new Scanner(System.in);

        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        displayActorsWithLastName();
        displayFilmsWithActor();

    }

    public static void displayFilmsWithActor(){
        System.out.println("Which actors films do you want to see");
        System.out.print("Enter their first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter their last name: ");
        String lastName = scanner.nextLine().trim();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT title, description, release_year, first_name,last_name  FROM sakila.film_actor s\n" +
                    "JOIN film f ON s.film_id = f.film_id\n" +
                    "JOIN actor a ON s.actor_id = a.actor_id\n" +
                    "WHERE a.first_name LIKE ? AND a.last_name LIKE ?")
        ) {
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            displayResults(statement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayActorsWithLastName(){
        System.out.println("Enter the last name of an actor you like: ");
        String lastName = scanner.nextLine().trim();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM sakila.actor WHERE last_name LIKE ?")
        ){
            statement.setString(1, lastName);
            displayResults(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
