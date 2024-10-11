package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
Requirements
• Use the provided products.csv file to load the store's product
inventory into your application.
• Create a Product class that stores all of the properties defined in
the csv file
• Customers should be able to view all products
o They should also be able to search by Product Name,
Price or Department
• Customers should be able to add products to their cart
• Customers should be able to remove products from their cart

Screens
• The Store Home Screen - The home screen should display a list
of options that a user can choose from.
o Display Products
o Display Cart
o Exit - closes out of the application
• Display Products - Displays a list of products that your store
sells.
o On this screen the customer should be able to
- Search or filter the list of products
- Add a product to their cart
- Go Back to the home page
• Display Cart - This displays a list of line items that are in the
customer's cart. It should also display the total sales amount of
the cart.
o The customer should be able to:
- Check Out
- Remove Product from the cart
- Go Back to the home screen
o If the customer chooses to remove a product need to prompt
them for the product to remove

 */

public class Store {
    public static void main(String[] args) {

     ArrayList<Product> inventory = getInventory();
     ArrayList<Product> cart = new ArrayList<>();
     Scanner input = new Scanner(System.in);
     int selection = 0;

     while(true) {
         try {
             System.out.println("Select an option by typing the number:\n" +
                     "1.Display Products\n" +
                     "2.Display Cart\n" +
                     "3.Exit");
             selection = input.nextInt();

             switch (selection) {

                 case 1:
                     displayProducts(inventory);
                     System.out.println("Select an option by typing the number:\n" +
                             "1. Add product\n" +
                             "2. Search for a product by name\n" +
                             "3. Search for products by a price range\n" +
                             "4. Search for products by their department\n" +
                             "5. Go back to the home page");
                     int selection1 = input.nextInt();
                     switch (selection1) {
                         case 1:
                             addToCart(inventory, cart);
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
                     System.out.println(displayCart(cart));
                     System.out.println("Select an option by typing the number:\n" +
                             "1.Checkout\n" +
                             "2.Remove from cart\n" +
                             "3.Go back to home screen");
                     int selection2 = input.nextInt();
                     switch (selection2) {
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

         } catch (Exception e){
             System.out.println("Invalid input");
             input.nextLine();
             e.printStackTrace();
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

    }

    public static void addToCart(ArrayList<Product> inventory, ArrayList<Product> cart){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of an item to add it to your cart: ");
        String productName = input.nextLine().trim();
        for (Product p : inventory){
            if( p.getProductName().equalsIgnoreCase(productName)){
                cart.add(p);
                System.out.println("Item added successully");
            }
        }
        if (cart.isEmpty()){
            System.out.println("Error. Nothing added to cart.");
        }

    }
    public static String displayCart (ArrayList<Product> cart){
        StringBuilder output = new StringBuilder("Items in cart:\n");
        HashMap<Product,Integer> items = new HashMap<>();
        for( Product p : cart){
            items.put(p, items.getOrDefault(p,0)+1);
        }
        for(Product p : items.keySet()){
            output.append(p.getProductName()).append("    Amount: ").append(items.get(p)).append(String.format("   Cost: $%.2f\n",p.getPrice() * items.get(p)));
        }
        return output.toString();
    }
    public static void checkOut(ArrayList<Product> cart){
        Scanner input = new Scanner(System.in);
        if (!cart.isEmpty()) {
            System.out.println(displayCart(cart));
            double cost = 0;
            for (Product p : cart) {
                cost += p.getPrice();
            }
            System.out.printf("Total cost: $%.2f\n", cost);
            System.out.print("Enter the payment amount(e.g 200): ");
            double payment = input.nextDouble();
            if (payment >= cost) {
                printReceipt(payment,cost,cart);
                System.out.println("Checked out successfully!");
                cart.clear();
                if (payment > cost) {
                    System.out.printf("Your change: %.2f\n", (payment - cost));
                }
            } else {
                System.out.println("Insufficient payment amount\nUnsuccessful checkout");
            }
        }
        else
            System.out.println("Nothing in the cart");
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
    public static void printReceipt(double payment, double cost, ArrayList<Product> cart){
        System.out.println("Date: "+ LocalDate.now());
        System.out.println(displayCart(cart));
        System.out.printf("Sales total: $%.2f\n",cost);
        System.out.printf("Amount paid: $%.2f\n",payment);
        System.out.printf("Change given: $%.2f\n",payment-cost);

        try{
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
            FileWriter fileWriter = new FileWriter("Receipts/"+now.format(df)+".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Date: "+ LocalDate.now()+"\n");
            bufferedWriter.write(displayCart(cart));
            bufferedWriter.write(String.format("Sales total: $%.2f\n",cost));
            bufferedWriter.write(String.format("Amount paid: $%.2f\n",payment));
            bufferedWriter.write(String.format("Change given: $%.2f\n",payment-cost));

            bufferedWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
