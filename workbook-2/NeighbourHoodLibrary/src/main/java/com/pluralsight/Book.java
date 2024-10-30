package com.pluralsight;

import javax.swing.*;

/*
Properties:
id: int
isbn: String
title: String
isCheckedOut: boolean
checkedOutTo: String
Methods:
checkOut(name)
checkIn()

 */
public class Book {
    private int id;
    private String isbn,title,checkedOutTo;
    private boolean isCheckedOut;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        checkedOutTo = "";
        this.isCheckedOut = false;
    }

    public void checkOut(String name){
        this.checkedOutTo = name;
        this.isCheckedOut = true;
        System.out.println("Checked out: "+this.title);
    }

    public void checkOut(String name, JFrame frame){
        this.checkedOutTo = name;
        this.isCheckedOut = true;
        JOptionPane.showMessageDialog(null,"Checked out successfully");
        frame.setVisible(false);
    }

    public void checkIn(){
        if (isCheckedOut){
            this.isCheckedOut=false;
            this.checkedOutTo = "";
        }
        else
            System.out.println("Book is already checked in");
    }

    public void checkIn(JFrame frame){
        if (isCheckedOut){
            this.isCheckedOut=false;
            this.checkedOutTo = "";
            JOptionPane.showMessageDialog(null,"Book checked in successfully");
            frame.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null,"Error. Book is already checked in.");
            frame.setVisible(false);
        }
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }
    public boolean getCheckoutStatus(){
        return isCheckedOut;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    @Override
    public String toString() {
        if (this.isCheckedOut()) {
            return "id: " + id +
                    ", isbn: " + isbn + '\'' +
                    ", title: " + title + '\'' +
                    ", checkedOutTo: '" + checkedOutTo + '\'';
        }
        else{
            return "id: " + id +
                    ", isbn: " + isbn + '\'' +
                    ", title=: " + title + '\'';
        }
    }
}
