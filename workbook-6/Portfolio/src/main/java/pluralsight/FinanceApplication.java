package pluralsight;

import pluralsight.finance.assets.BankAccount;
import pluralsight.finance.assets.Portfolio;

import java.util.Scanner;

public class FinanceApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your firs tName");
        String firstName = input.nextLine();
        System.out.println("Enter your last Name");
        String lastName = input.nextLine();
        Portfolio myPortfolio = new Portfolio(firstName,lastName);
        while (true){
            System.out.println("Select an asset to add\n" +
                    "1.BankAccount" + "\n" +
                    "2.Credit card\n" +
                    "3.Gold\n" +
                    "3.House\n" +
                    "4.Jewelry\n");
        }

    }
}
