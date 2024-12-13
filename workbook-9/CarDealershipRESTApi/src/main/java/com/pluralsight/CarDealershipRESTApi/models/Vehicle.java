package com.pluralsight.CarDealershipRESTApi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Vehicle {

      @Id
      @Column(name = "VIN", unique = true, nullable = false)
      private String VIN;
      @Column
      private String make;
      @Column
      private String model;
      @Column
      private int year;
      @Column
      private int mileage;
      @Column
      private double price;
      @Column
      private int sold;
      @Column
      private String color;
      @Column
      private String type;

      public Vehicle() {
      }


      public String getVIN() {
            return this.VIN;
      }

      public String getMake() {
            return this.make;
      }

      public String getModel() {
            return this.model;
      }

      public int getYear() {
            return this.year;
      }

      public int getMileage() {
            return this.mileage;
      }

      public double getPrice() {
            return this.price;
      }

      public int getSold() {
            return this.sold;
      }

      public String getColor() {
            return this.color;
      }

      public String getType() {
            return this.type;
      }

      public void setVIN(String VIN) {
            this.VIN = VIN;
      }

      public void setMake(String make) {
            this.make = make;
      }

      public void setModel(String model) {
            this.model = model;
      }

      public void setYear(int year) {
            this.year = year;
      }

      public void setMileage(int mileage) {
            this.mileage = mileage;
      }

      public void setPrice(double price) {
            this.price = price;
      }

      public void setSold(int sold) {
            this.sold = sold;
      }

      public void setColor(String color) {
            this.color = color;
      }

      public void setType(String type) {
            this.type = type;
      }

      public String toString() {
            return "Vehicle(VIN=" + this.getVIN() + ", make=" + this.getMake() + ", model=" + this.getModel() + ", year=" + this.getYear() + ", mileage=" + this.getMileage() + ", price=" + this.getPrice() + ", sold=" + this.getSold() + ", color=" + this.getColor() + ", type=" + this.getType() + ")";
      }
}
