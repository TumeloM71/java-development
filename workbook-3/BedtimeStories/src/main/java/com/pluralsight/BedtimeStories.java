package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Select an option by typing the respective number\n" +
                "1.Goldilocks\n" +
                "2.Hansel and Gretel\n" +
                "3.Mary had a little lamb\n");

        int choice = userInput.nextInt();
        while ( !(choice<4 && choice>0)) {
            System.out.println("Wrong input.Try again");
            choice = userInput.nextInt();
        }

        switch(choice){

            case 1:
                try {
                    FileInputStream goldilocks = new FileInputStream("src/resources/goldilocks.txt");
                    Scanner fileInput = new Scanner(goldilocks);
                    String line;
                    int i = 1;
                    while(fileInput.hasNextLine()){
                        line = fileInput.nextLine();
                        System.out.println(i++ +"."+line);
                    }
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    FileInputStream goldilocks = new FileInputStream("src/resources/hansel_and_gretel.txt");
                    Scanner fileInput = new Scanner(goldilocks);
                    String line;
                    int i = 1;
                    while(fileInput.hasNextLine()){
                        line = fileInput.nextLine();
                        System.out.println(i++ +"."+line);
                    }
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                try {
                    FileInputStream goldilocks = new FileInputStream("src/resources/mary_had_a_little_lamb.txt");
                    Scanner fileInput = new Scanner(goldilocks);
                    String line;
                    int i = 1;
                    while(fileInput.hasNextLine()){
                        line = fileInput.nextLine();
                        System.out.println(i++ +"."+line);
                    }
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }

}
}
