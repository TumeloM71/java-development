package com.pluralsight;
/*
Create a new Java application names BedtimeStories.
Unzip the DataFiles.zip file and copy the three children's stories to your
BedtimeStories project folder. (goldilocks.txt, hansel_and_gretel.txt
and mary_had_a_little_lamb.txt).
Each story text file contains a childrens bedtime story.
For example:
Goldilocks.txt
Goldilocks and the Three Bears
Once upon a time a girl named Goldilocks lived in
a house at the edge of the woods. In those days
curls of hair were called "locks." She was
"Goldilocks" because golden hair ran down her head
and shoulders.
Prompt the user for the name of the story/file to read.
Use a new Scanner to load and read each line of the selected story in the file.
Print the file to the screen, but add a line number to the beginning of each line

 */
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
