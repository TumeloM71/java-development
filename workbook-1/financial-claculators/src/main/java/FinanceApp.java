import java.util.Scanner;
import com.pluralsight.FutureValueCalculator;
import com.pluralsight.MortgageCalculator;

public class FinanceApp {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("The following calculators are available:\n" +
                "1.Mortgage Calculator\n" +
                "2.Future Value Calculator\n" +
                "Select option 1 or 2 by simply typing the respective number.");
        //Asks user to choose which application to run and stores the answer in "option"
        int option = userInput.nextInt();
        //Switch statement executes the respective application based on "option"
        switch (option){
            case 1:
                MortgageCalculator.main();
                break;

            case 2:
                FutureValueCalculator.main();
                break;
        }

    }
}
