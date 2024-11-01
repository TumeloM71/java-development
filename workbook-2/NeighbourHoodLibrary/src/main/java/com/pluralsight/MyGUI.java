package com.pluralsight;

import javax.swing.*;
import java.awt.*;

public class MyGUI {
    MyButton button1;
    MyButton button2;
    MyButton exitButton;
    MyFrame frame;
    Book[] books;
    public MyGUI(Book[] books){
        this.books = books;
    }

    public void mainDisplay(){
        frame = new MyFrame(Color.ORANGE);
        frame.setTitle("Candlehearth Keep Library");
        frame.setSize(400,400);
        button1 = new MyButton("Show available books");
        button1.setBounds(50,30,200,25);
        frame.add(button1);
        button1.addActionListener(e -> showAvailableBooks(books, new MyFrame(Color.CYAN)));

        button2 = new MyButton("Show checked out books");
        button2.setBounds(50,60,200,25);
        frame.add(button2);
        button2.addActionListener(e ->showCheckedOutBooks(books,new MyFrame(Color.YELLOW)));

        exitButton = new MyButton("Exit");
        exitButton.setBounds(50,90,200,25);
        frame.add(exitButton);
        exitButton.addActionListener(e -> System.exit(0));
    }

    public void showAvailableBooks(Book[] books, JFrame frame){
        //GUI method
        frame.setSize(800,700);
        frame.setTitle("Available books");
        JLabel label= new JLabel("Available books. Click a book to checkout");
        label.setBounds(50,5,400,20);
        frame.add(label);
        int yPosition = 25;
        for(Book book : books){
            if( !book.getCheckoutStatus()){
                MyButton bookButton = new MyButton(book.toString());
                bookButton.setBounds(10,yPosition,600,25);
                bookButton.addActionListener( e -> book.checkOut(getNameMenu(),frame));
                frame.add(bookButton);
                yPosition+=30;
            }
        }
        MyButton backButton = new MyButton("Go back to previous menu");
        backButton.setBounds(10,yPosition,600,25);
        backButton.addActionListener(e -> frame.dispose());
        frame.add(backButton);
    }

    public void showCheckedOutBooks(Book[] books,JFrame frame){
        frame.setSize(800,700);
        frame.setTitle("Checked out books");
        JLabel label= new JLabel("Checked out books. Click a book to check it in");
        label.setBounds(50,5,600,20);
        frame.add(label);
        int yPosition = 25;
        for(Book book : books){
            if(book.getCheckoutStatus()){
                MyButton bookButton = new MyButton(book.toString());
                bookButton.setBounds(10,yPosition,700,25);
                bookButton.addActionListener( e -> book.checkIn(frame));
                frame.add(bookButton);
                yPosition+=30;
            }
        }
        MyButton backButton = new MyButton("Go back to previous menu");
        backButton.setBounds(10,yPosition,700,25);
        backButton.addActionListener(e -> frame.dispose());
        frame.add(backButton);
    }

    public String getNameMenu(){
        String name = JOptionPane.showInputDialog("Enter your name");
        return name;
    }
}
