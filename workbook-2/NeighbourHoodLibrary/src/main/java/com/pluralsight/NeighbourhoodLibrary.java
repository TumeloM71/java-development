package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class NeighbourhoodLibrary {

    public static void main(String[] args) {


        Book[] books = new Book[20];
        Random random = new Random();
        String[] manga = {"Bleach","Jujutsu Kaisen","Naruto","Chainsaw Man",
                "Frieren: Beyond Journey's End","Attack on Titan","One Piece","Hunter x Hunter"};
        //Select a random manga from the array and assign it a random volume to make the title
        for(int i = 0; i< books.length; i++){
            String title = manga[random.nextInt(manga.length)]+" Volume "+random.nextInt(25);
            //Array index is used as the bookID
            int id = i+1;
            //13 digit ISBN made with random object
            String isbn = Long.toString(random.nextLong(9_999_999_999_999L));
            books[i] = new Book(id, isbn, title);
        }

        Scanner input = new Scanner(System.in);
        int option = 0;
        /*While loop keeps the program running until the user exits
        Options are 1: Show available books 2: Show checked out books 3: exit
       */
        while(option!=3) {
            System.out.println("Select an option: \n" + "1.Show available books\n" + "2.Show checked out books\n" + "3.Exit");
            option = input.nextInt();
            input.nextLine();
            //A combination of switch and if-else used for the conditional statements
            switch (option) {
                //Option under Show available books are 1.Select a book by typing the id 2.Exit
                case 1:
                    showAvailableBooks(books);
                    System.out.println("Select an a book to checkout by typing the book id or press 0 to exit");
                    int choice = input.nextInt();
                    input.nextLine();
                    if (choice > books.length + 1 && choice > 0)
                        System.out.println("Invalid Id");
                    else if (choice == 0)
                        break;
                    //checkOut is called for the selected book with the user's name as the parameter
                    else {
                        books[choice - 1].setCheckedOut(true);
                        System.out.print("Enter your name: ");
                        books[choice - 1].checkOut(input.nextLine().trim());
                    }
                    break;
                case 2:
                    //Options under showCheckedOutBooks are C. Check in a book or X. exit
                    showCheckedOutBooks(books);
                    System.out.println("Select an option:\nC.Check in a book\nX.Exit to home screen");
                    String selection = input.nextLine().trim();
                    if (selection.equalsIgnoreCase("C")) {
                        System.out.print("Enter the book id: ");
                        int bookId = input.nextInt()-1;
                        System.out.println(books[bookId]);
                        books[bookId].checkIn();
                        System.out.println(books[bookId]);
                    } else if (selection.equalsIgnoreCase("X"))
                        break;
                    else
                        throw new IllegalArgumentException("Unexpected value: " + selection);
                    break;
                case 3:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }
    }

    public static void showAvailableBooks(Book[] books){
        System.out.println("Available books:");
        for(Book book : books){
            if( !book.getCheckoutStatus())
                System.out.println(book);
        }
    }

    public static void showCheckedOutBooks(Book[] books){
        System.out.println("Checked out books:");
        for(Book book : books){
            if(book.getCheckoutStatus())
                System.out.println(book);
        }

    }
}
