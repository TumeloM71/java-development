package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
public class Store {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner input = new Scanner(System.in);
        while(true) {
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
                if (command > 0 && command <= 5) {
                    switch (command) {
                        case 1:
                            for (Product p : inventory)
                                System.out.println(p.toString());
                            break;
                        case 2:
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
                            break;
                        case 3:
                            System.out.print("Enter the lower bound:");
                            int lowerBound = input.nextInt();
                            System.out.print("Enter the upper bound:");
                            int upperBound = input.nextInt();
                            System.out.println("Items found:");
                            for (Product p : inventory) {
                                if (p.getPrice() >= lowerBound && p.getPrice() <= upperBound)
                                    System.out.println(p.toString());
                            }
                            break;
                        case 4:
                            System.out.print("Enter the product id: ");
                            int newProductId = input.nextInt();
                            System.out.print("Enter the product name: ");
                            String newProductName = input.nextLine().trim();
                            System.out.println("Enter the price(e.g 59.99): ");
                            float newProductPrice = input.nextFloat();
                            inventory.add(new Product(newProductId, newProductName, newProductPrice));
                            break;
                        case 5:
                            System.exit(0);
                    }
                } else
                    System.out.println("Invalid number");
            } catch (Exception e) {
                System.out.println("Error. Wrong input");
                input.nextLine(); //Clears invalid input from input stream to avoid an infinite loop
            }
        }

    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        Product game = new Product(4300,"Elden Ring", 59.99F);
        inventory.add(game);
        game = new Product(2402,"Helldivers 2", 49.99F);
        inventory.add(game);
        game = new Product(2308,"Baldur's Gate 3", 59.99F);
        inventory.add(game);
        game = new Product(1601,"Dragon's Dogma: Dark Arisen", 29.99F);
        inventory.add(game);
        game = new Product(1808,"Monster Hunter: World", 59.99F);
        inventory.add(game);
        game = new Product(1912,"Red Dead Redemption 2", 59.99F);
        inventory.add(game);

        return inventory;
    }
}

