package com.pluralsight;


public class Vehicle {
    private long vehicleId;
    private String makeModel,color;
    private int odometerReading;
    private double price;

    public Vehicle(long vehicleId, String makeModel, String color, int odometerReading, double price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "Name:"+ this.getMakeModel()+"\tColor:"+ this.getColor()
                +"\tPrice:"+ this.getPrice()+"\tMileage:"+ this.getOdometerReading();
    }
}
