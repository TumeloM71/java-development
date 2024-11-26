import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("What is your name");
        String name = input.nextLine().trim();
        System.out.printf("Hello %s!",name);
    }
}
