import java.util.Scanner;

public class Psychic {

    static Scanner input = new Scanner(System.in);
    static int guess;
    static int num;
    public static double guess() {

        for (int i = 0; i < 5; i++) {
            System.out.print("Make a guess: ");
            guess = input.nextInt();
            num = (int) (Math.random() * guess * 2);
            if (guess == num) {
                System.out.println("Congrats. You've won.");
                System.exit(0);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        guess();
    }
}
