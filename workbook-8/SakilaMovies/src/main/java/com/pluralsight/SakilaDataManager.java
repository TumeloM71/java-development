package com.pluralsight;

import com.pluralsight.model.Actor;
import com.pluralsight.model.Film;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SakilaDataManager {

    static String userName = null;
    static String password = null;
    static Scanner scanner = new Scanner(System.in);
    static BasicDataSource dataSource;

    public static String askForFirstName(){
        System.out.print("Enter the first name: ");
        return scanner.nextLine().trim();
    }

    public static String askForLastName(){
        System.out.print("Enter the last name: ");
        return scanner.nextLine().trim();
    }

    //returns a list of actors from the database with the given firstName
    public static List<Actor> getActorsByFirstName(String firstName) {
        System.out.println();

        List<Actor> actors;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT actor_id, first_name, last_name FROM sakila.actor \n" +
                     "WHERE first_name LIKE ?")
        ) {
            statement.setString(1, '%'+firstName+'%');
            actors = getActorsList(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actors;
    }

    public static List<Actor> getActorsByLastName(String lastName) {

        System.out.println();
        List<Actor> actors;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT actor_id, first_name, last_name FROM sakila.actor \n" +
                     "WHERE last_name LIKE ?")
        ) {
            statement.setString(1,'%'+lastName+'%');
            actors = getActorsList(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actors;
    }

    public static List<Actor> getActorsByFullName(String firstName, String lastName) {

        System.out.println();

        List<Actor> actors;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT actor_id, first_name, last_name FROM sakila.actor \n" +
                     "WHERE first_name LIKE ? AND last_name LIKE ?")
        ) {
            statement.setString(1,'%'+ firstName + '%');
            statement.setString(2, '%' + lastName + '%');
            actors = getActorsList(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actors;
    }

    //Returns a list of Actors from the given query statement
    public static List<Actor> getActorsList(PreparedStatement statement) {
        List<Actor> actors = new ArrayList<>();
        try (ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                Actor actor = new Actor(results.getInt(1), results.getString(2), results.getString(3));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

    public static int askForActorId(){
        System.out.print("Enter the actorId: ");
        return scanner.nextInt();
    }

    //Returns a list of films from the given actorId
    public static List<Film> getFilmsByActorId() {

        int actorId = askForActorId();
        List<Film> films;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT f.film_id,title,description,length,release_year FROM sakila.film_actor s " +
                     "JOIN film f ON s.film_id = f.film_id " +
                     "JOIN actor a ON s.actor_id = a.actor_id " +
                     "WHERE s.actor_id LIKE ?")
        ) {
            statement.setInt(1, actorId);
            films = getFilmsList(statement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return films;
    }

    public static List<Film> getFilmsList(PreparedStatement statement) {
        List<Film> films = new ArrayList<>();
        try (ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                int filmId = results.getInt(1);
                String title = results.getString(2);
                String description = results.getString(3);
                int length = results.getInt(4);
                Year releaseYear = Year.of(results.getInt(5));
                Film film = new Film(filmId, title, description, length, releaseYear);
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    public static void displayFilmsWithActor() {
        System.out.println("Which actors films do you want to see");
        String firstName = askForFirstName();
        String lastName = askForLastName();

        System.out.println();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT title, description, release_year, first_name,last_name  FROM sakila.film_actor s\n" +
                     "JOIN film f ON s.film_id = f.film_id\n" +
                     "JOIN actor a ON s.actor_id = a.actor_id\n" +
                     "WHERE a.first_name LIKE ? AND a.last_name LIKE ?")
        ) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            displayResults(statement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayActorsWithLastName() {

        String lastName = askForLastName();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM sakila.actor WHERE last_name LIKE ?")
        ) {
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
                    String columnLabel = results.getMetaData().getColumnLabel(i);
                    String columnVal = results.getString(i);
                    String spaces = " ".repeat(15-columnLabel.length());
                    System.out.print(columnLabel+spaces+": ");
                    System.out.print(columnVal + '\n');
                }
                System.out.println("---".repeat(80));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        SakilaDataManager.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        SakilaDataManager.password = password;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        SakilaDataManager.scanner = scanner;
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(BasicDataSource dataSource) {
        SakilaDataManager.dataSource = dataSource;
    }
}
