package com.pluralsight;

import javax.swing.text.Caret;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        Asset regularHouse = new House("Dallas house","2006-06-30",115000, 10000,"Dallas, TX",3,18000);
        Asset vacationHouse = new House("Miami house","2017-08-09",320000,20000,"Miami, FL",2,30000);
        Asset mustang = new Vehicle("Car","2019-10-12",35000,"Ford Mustang",5,50000);
        Asset ninja_400 = new Vehicle("Motorcycle","2023-04-04",7400,"Kawasaki Ninja 400",1,10000);

        assets.add(regularHouse); assets.add(vacationHouse);
        assets.add(mustang); assets.add(ninja_400);

        for( Asset asset : assets){
            System.out.println(asset.toString());
            if ( asset instanceof House)
                System.out.println("House at "+ ((House) asset).getAddress());

            if (asset instanceof Vehicle)
                System.out.println("Vehicle: "+((Vehicle) asset).getMakeModel());

            System.out.println();

        }

    }

}
