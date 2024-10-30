package com.pluralsight;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourhoodLibraryTest {


    @org.junit.jupiter.api.Test
    void showAvailableBooks() {
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

        showAvailableBooks();
    }

    @org.junit.jupiter.api.Test
    void showCheckedOutBooks() {
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

        books[1].checkOut("Tumelo");
    }
}