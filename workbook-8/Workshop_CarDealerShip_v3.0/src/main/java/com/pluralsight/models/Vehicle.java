package com.pluralsight.models;

public record Vehicle(String VIN, String make, String model,
                      int year, int mileage, double price, int sold,
                      String color, String type) {
}
