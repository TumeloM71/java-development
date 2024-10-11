package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {

     ArrayList<Product> inventory = getInventory();
     ArrayList<Product> cart = new ArrayList<>();
     Scanner input = new Scanner(System.in);
     int selection = 0;

     while(true){
         System.out.println("Select an option by typing the number:\n" +
                 "1.Display Products\n" +
                 "2.Display Cart\n" +
                 "3.Exit");
         selection = input.nextInt();

         switch (selection){

             case 1:
                 displayProducts(inventory);
                 System.out.println("Select an option by typing the number:\n" +
                         "1. Add product\n" +
                         "2. Search for a product by name\n"+
                         "3. Search for products by a price range\n"+
                         "4. Search for products by their department\n"+
                         "5. Go back to the home page");
                 int selection1 = input.nextInt();
                 switch (selection1){
                     case 1:
                         addToCart(inventory,cart);
                         break;
                     case 2:
                         searchByName(inventory);
                         break;
                     case 3:
                         searchByPriceRange(inventory);
                         break;
                     case 4:
                         searchByDepartment(inventory);
                         break;
                     case 5:
                         continue;
                     default:
                         System.out.println("Error. Invalid input.");
                         break;
                 }
                 break;

             case 2:
                 displayCart(cart);
                 System.out.println("Select an option by typing the number:\n"+
                                    "1.Checkout\n" +
                                    "2.Remove from cart\n"+
                                    "3.Go back to home screen");
                 int selection2 = input.nextInt();
                 switch (selection2){
                     case 1:
                         checkOut(cart);
                         break;
                     case 2:
                         removeFromCart(cart);
                         break;
                     case 3:
                         continue;
                     default:
                         System.out.println("Error. Invalid input.");
                         break;
                 }

                 break;

             case 3:
                 System.exit(0);
             default:
                 System.out.println("Error. Invalid input.");
                 break;

         }
     }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        try {

            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input ;
            bufferedReader.readLine();

            while ((input = bufferedReader.readLine()) != null) {

                String[] item = input.split("\\|");
                Product newProduct = new Product(item[0], item[1], Double.parseDouble(item[2]),item[3]);
                inventory.add(newProduct);

            }

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return inventory;
    }

    public static void displayProducts (ArrayList<Product> inventory){
        System.out.println("Products for sale:");
        for( Product p : inventory){
            System.out.println(p);
        }
    }

    public static void searchByName(ArrayList<Product> inventory){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the product name: ");
        String productName = input.nextLine().trim();
        System.out.println("Products found:");
        for( Product p : inventory){
            if( p.getProductName().equalsIgnoreCase(productName)){
                System.out.println(p);
            }
        }
    //    input.close();
    }
    public static void searchByPriceRange(ArrayList<Product> inventory){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the minimum price:");
        double lowerBound = input.nextDouble();
        System.out.print("Enter the maximum price:");
        double upperBound = input.nextDouble();
        System.out.println("Items found:");
        for (Product p : inventory) {
            if (p.getPrice() >= lowerBound && p.getPrice() <= upperBound)
                System.out.println(p.toString());
        }
    //    input.close();
    }

    public static void searchByDepartment(ArrayList<Product> inventory){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a department from the list below:");
        System.out.println("Audio Video\nComputers\nGames\nElectronics");
        String department = input.nextLine().trim();
        for (Product p : inventory){
            if( department.equalsIgnoreCase(p.getDepartment())){
                System.out.println(p);
            }
        }
    //    input.close();
    }

    public static void addToCart(ArrayList<Product> inventory, ArrayList<Product> cart){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of an item to add it to your cart: ");
        String productName = input.nextLine().trim();
        for (Product p : inventory){
            if( p.getProductName().equalsIgnoreCase(productName)){
                cart.add(p);
            }
        }
        if (cart.isEmpty()){
            System.out.println("Error. Nothing added to cart.");
        }
    //    input.close();
    }
    public static void displayCart (ArrayList<Product> cart){
        System.out.println("Items in cart:");
        for( Product p : cart){
            System.out.println(p);
        }
    }
    public static void checkOut(ArrayList<Product> cart){
        displayCart(cart);
        System.out.println("Checked out successfully!");
        cart.clear();
    }

    public static void removeFromCart (ArrayList<Product> cart){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the item you want to remove");
        String productName = input.nextLine();
        Product itemToRemove = null;
        for (Product p : cart){
            if ( p.getProductName().equalsIgnoreCase(productName)){
                itemToRemove = p;
                break;
            }
        }
        cart.remove(itemToRemove);

    }

}
