package com.pluralsight;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException {
        Dealership cheapCars = DealershipFileManager.getDealership();
        System.out.println(cheapCars);
    }
}
