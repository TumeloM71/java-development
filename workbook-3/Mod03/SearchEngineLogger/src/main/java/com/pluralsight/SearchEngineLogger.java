package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/*
Create a Java application named com.pluralsight.SearchEngineLogger.
Create a method to log the actions of the user. Write each user action to a file
name logs.txt.
Actions include:
a. Launching the application
b. Searching for a term
c. Exiting the application
In the main() method prompt the user for a search term that they wish to
search.

Enter a search term (X to exit):

2023-09-06 12:42:20 launch
2023-09-06 12:42:45 search : How to use ChatGPT
2023-09-06 12:43:51 search : How to forge a camp knife
2023-09-06 12:45:32 exit

 */
public class SearchEngineLogger {
    public static void main(String[] args) {
       try{
           FileWriter fileWriter = new FileWriter("log.txt");
           BufferedWriter logger = new BufferedWriter(fileWriter);

           DateTimeFormatter df =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
           LocalDateTime now;

           Scanner input = new Scanner(System.in);
           String userInput = "";

           now = LocalDateTime.now();
           logger.write(now.format(df)+" launch\n");

           while(!userInput.equalsIgnoreCase("X")){
               System.out.print("Enter a search term (X to exit):");
               userInput = input.nextLine().trim();

               if (userInput.equalsIgnoreCase("X")) {
                   now = LocalDateTime.now();
                   logger.write(now.format(df)+" exit\n");
                   continue;

               } else{
                   now = LocalDateTime.now();
                   logger.write(now.format(df)+" : "+userInput+"\n");
               }
           }
           logger.close();
           fileWriter.close();
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}
