package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {

        String[] quotes = { "Programs must be written for people to read, and only incidentally for machines to execute. - Harold Abelson",
                "Talk is cheap. Show me the code. - Linus Torvalds",
                "First, solve the problem. Then, write the code. - John Johnson",
                "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. - Martin Fowler",
                "The best error message is the one that never shows up. - Thomas Fuchs",
                "Simplicity is the soul of efficiency. - Austin Freeman",
                "If debugging is the process of removing software bugs, then programming must be the process of putting them in. - Edsger Dijkstra",
                "It's not that I'm so smart, it's just that I stay with problems longer. - Albert Einstein",
                "Programming isn't about what you know; it's about what you can figure out. - Chris Pine",
                "The computer was born to solve problems that did not exist before. - Bill Gates"
            };
        Scanner input = new Scanner(System.in);
        String yesOrNo = "yes";
        while (!yesOrNo.equalsIgnoreCase("no")) {
            try {
                System.out.println("Select :\n" +
                        "1.A number from 1 to 10 to print the associated quote\n" +
                        "2.Type 0 for a random quote");
                int i = input.nextInt();
                if (i == 0){
                    Random random = new Random();
                    System.out.println(quotes[random.nextInt(9)]);
                }
                else {
                    input.nextLine();
                    int choice = i - 1;
                    System.out.println(quotes[choice]);
                }
            } catch (Exception e) {
                System.out.println("Wrong input. Please try again.");
            }
            System.out.println("Do you want to see another quote. Type Yes or No.");
            input.nextLine();
            yesOrNo = input.nextLine();
            if (!(yesOrNo.equalsIgnoreCase("yes")||yesOrNo.equalsIgnoreCase("no"))) {
                System.out.println("Wrong input. Please try again.");
                System.out.println("Do you want to see another quote. Type Yes or No.");
                yesOrNo = input.nextLine();
            }
        }
    }
}
