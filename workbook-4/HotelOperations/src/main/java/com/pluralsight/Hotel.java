package com.pluralsight;

public class Hotel {

    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }

    public boolean bookRoom(int numberOfRoomsToBook, boolean isSuite){
        if (isSuite)
            return getAvailableSuites()>=numberOfRoomsToBook;
        else
            return getAvailableRooms()>=numberOfRoomsToBook;
    }

    public int getAvailableSuites(){
        return getNumberOfSuites() - getBookedSuites();
    }

    public int getAvailableRooms(){
        return getNumberOfRooms() - getBookedRooms();
    }

    private String getName() {
        return name;
    }

    private int getNumberOfSuites() {
        return numberOfSuites;
    }

    private int getNumberOfRooms() {
        return numberOfRooms;
    }

    private int getBookedSuites() {
        return bookedSuites;
    }

    private int getBookedRooms() {
        return bookedRooms;
    }

}
