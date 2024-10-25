package com.pluralsight;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException {
        Dealership cheapCars = DealershipFileManager.getDealership();
        System.out.println(cheapCars);
        Vehicle mustang = new Vehicle(90999,"Mustang","Ford",2024,"blue","car",10000,30998);
        cheapCars.addVehicle(mustang);
        Vehicle challenger = new Vehicle(80888,"Challenger","Dodge",2023,"black","car",10000,23999);
        Vehicle charger = new Vehicle(81899,"Charger","Dodge",2020,"black","car",10000,36899);
        cheapCars.addVehicle(challenger);
        cheapCars.addVehicle(charger);

        for( Vehicle v : cheapCars.getAllVehicles()){
            System.out.println(v);
        }

        DealershipFileManager.saveDealearship(cheapCars);
    }
}
