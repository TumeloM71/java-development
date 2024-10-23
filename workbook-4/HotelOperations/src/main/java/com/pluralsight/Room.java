package com.pluralsight;

public class Room {

    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds) {
        this.price = 0;
        this.numberOfBeds = numberOfBeds;
        this.isOccupied = false;
        this.isDirty = false;
    }

    public void checkIn(Reservation r){
        this.price = r.getReservationTotal();
        System.out.println("Checked in successfully, Total cost: "+r.getReservationTotal());
        this.isOccupied = true;
        isDirty = true;
    }
    public void checkOut(){
        if (this.isOccupied){
            isOccupied = false;
            price = 0;
        }
        else
            System.out.println("Room is vacant.");
    }

    public void clean(){
        this.isDirty = false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isAvailable(){
        return !isOccupied && !isDirty;
    }

    public boolean isDirty() {
        return isDirty;
    }

}
