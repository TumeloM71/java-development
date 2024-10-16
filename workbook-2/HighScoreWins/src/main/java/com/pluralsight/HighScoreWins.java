package com.pluralsight;

import java.util.Scanner;
/*
Prompt the user for a game score.
The user will input a score in the following format:
Home:Visitor|21:9
Based on the user input, you should determine which team had the higher score
and display the name of the winning team.
Hint: You will have to split the text multiple times to get all of the information
- once on the pipe ( | )
- once on the colon ( : )
A sample trace of your program output is shown below. Bolded code is what the
user entered.
Please enter a game score: Home:Visitor|21:9↵
Winner: Home
A different trace would be:
Please enter a score: Slytherin:Gryffindor|23:59↵
Winner: Gryffindor

 */
public class HighScoreWins {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a game score: ");

        //First split separates the Home:Away apart from Score1:Score2
        String[] userInput = input.nextLine().trim().split("\\|");
        //The Home:Away string is further split into a teams array
        String[] teams = userInput[0].split(":");
        //The Score1:Score2 string is further split into a score array
        String[] score = userInput[1].split(":");

        //Scores are converted to integers so comparison can be done
        int homeScore = Integer.parseInt(score[0]);
        int awayScore = Integer.parseInt(score[1]);

        //Conditional statement for printing the output
        if (homeScore>awayScore)
            System.out.printf("Winner: %s",teams[0]);
        else if (awayScore>homeScore)
            System.out.printf("Winner: %s",teams[1]);
        else
            System.out.println("Draw");

    }
}
