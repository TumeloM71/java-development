package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
Create a new Java application SearchInventoryMap. Write the code for the
application that was demonstrated in the previous pages.
Add a loadInventory() method to load all of the products from the
Inventory.csv file. Create a product from each line and add it to a Map. Use
the product name as the map key so that users can search for products by name.
Test the application.
BONUS: Write code to let the user look up more than one product. After the
program displays the results of the search, ask the user "Do you want to search
again?". Keep repeating the search as long as they answer yes to the questio
 */

public class StoreInventory {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        HashMap<String, Product> inventory = getInventory();
        String userInput = "";
        System.out.println(inventory);

        while (true) {
            System.out.println("Enter product(s) by name separated by a |\nOr type exit to end the program:");
            userInput = input.nextLine();

            if (!(userInput.equalsIgnoreCase("exit"))) {
                searchByName(userInput,inventory);
            } else {
                break;
            }
        }
    }
    public static HashMap<String,Product> getInventory() {
        HashMap<String,Product> inventory = new HashMap<>();
        try {

            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input = bufferedReader.readLine();

            while (input != null) {
                String[] item = input.split("\\|");
                Product newProduct = new Product(Integer.parseInt(item[0]), item[1], Float.parseFloat(item[2]));
                inventory.put(newProduct.getName(),newProduct);
                input = bufferedReader.readLine();
            }

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return inventory;
    }

    public static void searchByName(String userInput, HashMap<String,Product> inventory){
        String[] searchItems = userInput.trim().split("\\|");
        for (String name : searchItems) {
            if (inventory.containsKey(name))
                System.out.println(inventory.get(name));
            else
                System.out.println("Item not found");
        }
    }

}
