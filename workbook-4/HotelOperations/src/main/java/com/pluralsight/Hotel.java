package com.pluralsight;

public class Hotel {

    String name;
    int numberOfSuites;
    int numberOfRooms;
    int bookedSuites;
    int bookedRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRoom) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRoom;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRoom, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRoom;
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
        return numberOfSuites-bookedSuites;
    }

    public int getAvailableRooms(){
        return numberOfRooms-bookedRooms;
    }
}
