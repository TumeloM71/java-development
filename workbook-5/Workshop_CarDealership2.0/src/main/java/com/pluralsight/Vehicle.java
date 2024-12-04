package com.pluralsight;

import java.util.Objects;

public class Vehicle {

    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(){}

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

    public Vehicle(String input){
        String[] lineSplit = input.split("\\|");
        this.vin = Utilities.getIntValue(lineSplit[0]);
        this.year = Utilities.getIntValue(lineSplit[1]);

        this.make = lineSplit[2]; this.model = lineSplit[3];
        this.vehicleType = lineSplit[4]; this.color =lineSplit[5];

        this.odometer = Utilities.getIntValue(lineSplit[6]);
        this.price = Utilities.getDoubleValue(lineSplit[7]);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return getVin() == vehicle.getVin() && getYear() == vehicle.getYear() && getOdometer() == vehicle.getOdometer() && Double.compare(getPrice(), vehicle.getPrice()) == 0 && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getVehicleType(), vehicle.getVehicleType()) && Objects.equals(getColor(), vehicle.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin(), getYear(), getMake(), getModel(), getVehicleType(), getColor(), getOdometer(), getPrice());
    }

    @Override
    public String toString(){
        return String.format("%d|%d|%s|%s|%s|%s|%d|$q%.2f",vin,
                year,make,model,vehicleType,color,odometer,price);
    }
}
