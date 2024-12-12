package com.pluralsight.NorthwindTradersRestApi.cli;

import com.pluralsight.NorthwindTradersRestApi.models.Product;
import com.pluralsight.NorthwindTradersRestApi.repository.ProductDAO;
import com.pluralsight.NorthwindTradersRestApi.repository.ProductDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CLI implements CommandLineRunner {

    Scanner scanner;
    ProductDAOImpl productDAO;

    @Autowired
    public CLI(ProductDAOImpl productDAO){
        this.productDAO = productDAO;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        runScreen();
    }

    public void runScreen() {

        boolean loopFlag = true;
        while(loopFlag) {
            System.out.println("""
                    (1) View all products
                    (2) Add a product
                    (3) Delete product
                    (0) Exit
                    """);
            switch (scanner.nextLine().trim()) {
                case "1" -> productDAO.getAll().forEach(System.out::println);
                case "2" -> add(productDAO);
                case "3" -> delete(productDAO);
                case "0" -> loopFlag = false;
                default -> System.out.println("Invalid input");
            }
        }
    }

    public void add (ProductDAO productDAO){

        System.out.println("Enter the product name");
        String name = scanner.nextLine();
        System.out.println("Enter the product category");
        String category = scanner.nextLine();
        System.out.println("Enter the price");
        double price = scanner.nextDouble();
        scanner.nextLine();

        productDAO.add(new Product(0,name,category,price));
    }

    public void delete(ProductDAO productDAO){
        System.out.println("Enter the productId");
        int id = scanner.nextInt();
        scanner.nextLine();
        productDAO.delete(id);
    }
}
