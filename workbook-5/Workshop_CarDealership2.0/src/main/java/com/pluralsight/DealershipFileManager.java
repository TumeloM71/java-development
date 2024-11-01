package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    private DealershipFileManager(){};

    public static Dealership getDealership() throws IOException {

        FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String firstLine = bufferedReader.readLine();
        String name = firstLine.split("\\|")[0],
                address = firstLine.split("\\|")[1],
                phone = firstLine.split("\\|")[2];

        ArrayList<Vehicle> inventory = new ArrayList<>();
        String input;

        while((input = bufferedReader.readLine())!=null){
            String[] lineSplit = input.split("\\|");
            int vin = Utilities.getIntValue(lineSplit[0]),
                    year = Utilities.getIntValue(lineSplit[1]);

            String make = lineSplit[2], model = lineSplit[3],
                    type = lineSplit[4], color =lineSplit[5];

            int odometer = Utilities.getIntValue(lineSplit[6]);
            double price = Utilities.getDoubleValue(lineSplit[7].substring(1));

            Vehicle vehicle = new Vehicle(vin,model,make,year,color,type,odometer,price);
            inventory.add(vehicle);
        }
        bufferedReader.close();
        return new Dealership(name,address,phone,inventory);
    }

    public static void saveDealearship(Dealership dealership) throws IOException{
        FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv");
        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);

        bufferedWriter.write(dealership.toString()+"\n");
        for( Vehicle v :dealership.getAllVehicles()){
            bufferedWriter.write(v.toString()+"\n");
        }
        bufferedWriter.close();
    }
}
