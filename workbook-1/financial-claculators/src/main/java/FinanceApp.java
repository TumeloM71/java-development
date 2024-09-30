import java.util.Scanner;
import com.pluralsight.FutureValueCalculator;
import com.pluralsight.MortgageCalculator;
import com.pluralsight.PresentValueOfAnnuityCalculator;

public class FinanceApp {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("The following calculators are available:\n" +
                "1.Mortgage Calculator\n" +
                "2.Future Value Calculator\n" +
                "3.Present Value of an Ordinary Annuity Calculator\n" +
                "Select option 1,2 or 3 by simply typing the respective number.\n");
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
            case 3:
                PresentValueOfAnnuityCalculator.main();
                break;
        }

    }
}
