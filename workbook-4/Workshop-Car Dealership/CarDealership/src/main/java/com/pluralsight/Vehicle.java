package com.pluralsight;

public class Vehicle {

    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, String model, String make, int year, String color, String vehicleType, int odometer, double price) {
        this.vin = vin;
        this.model = model;
        this.make = make;
        this.year = year;
        this.color = color;
        this.vehicleType = vehicleType;
        this.odometer = odometer;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    public int getVin() {
        return vin;
    }

    @Override
    public String toString(){
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",vin,
                year,make,model,vehicleType,color,odometer,price);
    }
}
