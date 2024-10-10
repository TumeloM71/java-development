package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/*
In the following exercise you will create an application to manage and search the
product inventory of a store using java collections.
EXERCISE 1
Create a new Java application named SearchInventory. You will code the
application we saw in the previous pages. The application displays the inventory
that our store carries.
You will need to code the getInventory() method and create an initial
inventory of at least 5 products. An ArrayList's size can change and will
continue to grow as long as you have the energy to place products in the list.
Test the application.

BONUS: Replace the code that loaded the ArrayList with code that reads data
from a file named inventory.csv. Create a file containing products that
resembles the following.
4567|10' 2x4 (grade B)|9.99
1234|Hammer|19.49
2345|Box of nails|9.29
Read the file a line at a time. Split the string where you find the pipe ( | )
character and use the parts to create a Product object. Add the object to the
ArrayList. The list will be able to accommodate however many products you
add to the file.
BONUS: Sort the products by name before you display them.

BONUS: Replace the user interface of the program with a menu driven one.
Provide a loop and prompt the user using a style resembling the following:
What do you want to do?
1- List all products
2- Lookup a product by its id
3- Find all products within a price range
4- Add a new product
5- Quit the application
Enter command:
 */
public class Store {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?\n" +
                    "1- List all products\n" +
                    "2- Lookup a product by its id\n" +
                    "3- Find all products within a price range\n" +
                    "4- Add a new product\n" +
                    "5- Quit the application");
            System.out.print("Enter command:");

            int command;
            try {
                command = input.nextInt();


                switch (command) {
                    case 1:
                        listByName(inventory);
                        break;
                    case 2:
                        searchById(inventory);
                        break;
                    case 3:
                        searchByPriceRange(inventory);
                        break;
                    case 4:
                        addProduct(inventory);
                        break;
                    default:
                        System.out.println("Invalid number");
                }
            } catch (Exception e) {
                System.out.println("Error. Wrong input");
                input.nextLine(); //Clears invalid input from input stream to avoid an infinite loop
            }
        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        try {

            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input = bufferedReader.readLine();

            while (input != null) {
                String[] item = input.split("\\|");
                Product newProduct = new Product(Integer.parseInt(item[0]), item[1], Float.parseFloat(item[2]));
                inventory.add(newProduct);
                input = bufferedReader.readLine();
            }

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return inventory;
    }

    public static void addProduct(ArrayList<Product> inventory){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the product id: ");
        int newProductId = input.nextInt();
        input.nextLine();

        System.out.print("Enter the product name: ");
        String newProductName = input.nextLine().trim();

        System.out.print("Enter the price(e.g 59.99): ");
        float newProductPrice = input.nextFloat();
        inventory.add(new Product(newProductId, newProductName, newProductPrice));
    }

    public static void searchByPriceRange(ArrayList<Product> inventory){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the lower bound:");
        float lowerBound = input.nextFloat();
        System.out.print("Enter the upper bound:");
        float upperBound = input.nextFloat();
        System.out.println("Items found:");
        for (Product p : inventory) {
            if (p.getPrice() >= lowerBound && p.getPrice() <= upperBound)
                System.out.println(p.toString());
        }
    }

    public static void searchById(ArrayList<Product> inventory){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the id:");
        int id = input.nextInt();

        Product searchItem = null;
        for (Product p : inventory) {
            if (p.getId() == id)
                searchItem = p;
        }
        if (searchItem != null)
            System.out.println(searchItem);
        else
            System.out.println("Not found");
    }

    public static void listByName(ArrayList<Product> inventory){
        Collections.sort(inventory, Comparator.comparing(Product::getName));
        for (Product p : inventory)
            System.out.println(p.toString());
    }

}

