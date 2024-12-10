package com.pluralsight.NorthwindTradersSpringBoot.cli;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot.repository.SimpleProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.repository.SimpleProductDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CLI implements CommandLineRunner {

    Scanner scanner;
    SimpleProductDAOImpl productDAO;

    @Autowired
    public CLI(SimpleProductDAOImpl productDAO){
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
                    (0) Exit
                    """);
            switch (scanner.nextLine().trim()) {
                case "1" -> productDAO.getAll().forEach(System.out::println);
                case "2" -> addAll(productDAO);
                case "0" -> loopFlag = false;
                default -> System.out.println("Invalid input");
            }
        }
    }

    public void addAll(SimpleProductDAO productDAO){
        System.out.println("Enter the product id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the product name");
        String name = scanner.nextLine();
        System.out.println("Enter the product category");
        String category = scanner.nextLine();
        System.out.println("Enter the price");
        double price = scanner.nextDouble();
        scanner.nextLine();

        productDAO.add(new Product(id,name,category,price));
    }
}
