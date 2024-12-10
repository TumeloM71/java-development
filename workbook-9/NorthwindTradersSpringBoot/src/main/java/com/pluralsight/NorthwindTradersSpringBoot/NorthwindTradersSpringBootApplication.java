package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot.repository.SimpleProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.repository.SimpleProductDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {


	static Scanner scanner = new Scanner(System.in);
	static SimpleProductDAO productDAO;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
		productDAO = context.getBean(SimpleProductDAOImpl.class);
		runScreen();
	}
	public static void runScreen() {


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

	public static void addAll(SimpleProductDAO productDAO){
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
