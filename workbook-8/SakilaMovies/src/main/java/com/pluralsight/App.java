package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

import static com.pluralsight.SakilaDataManager.*;

public class App {

    public static void main(String[] args) {

        String userName = args[0];
        String password = args[1];
        scanner = new Scanner(System.in);

        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        boolean loopFlag = true;

        try {
            while (loopFlag) {
                System.out.println();
                System.out.print("What do you want to do?\n" +
                        "1) Get list of actors by first name\n" +
                        "2) Get list of actors by last name\n" +
                        "3) Get list actors by full name\n" +
                        "4) Get list films by actorId\n" +
                        "5) Display films with specific actor name\n" +
                        "6) Display actors with specific last name\n" +
                        "0) Exit\n" +
                        "Select an option: ");

                int selection = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                switch (selection) {
                    case 1 -> SakilaDataManager.getActorsByFirstName(askForFirstName()).forEach(System.out::println);
                    case 2 -> getActorsByLastName(askForLastName()).forEach(System.out::println);
                    case 3 -> getActorsByFullName(askForFirstName(),askForLastName()).forEach(System.out::println);
                    case 4 -> getFilmsByActorId().forEach(System.out::println);
                    case 5 -> displayFilmsWithActor();
                    case 6 -> displayActorsWithLastName();
                    case 0 -> loopFlag = false;
                    default -> System.out.println("Invalid input. Try again");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}
