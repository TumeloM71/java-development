package com.pluralsight;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


//Dealership class, an instance holds a list of Vehicles
public class Dealership {

    String name;
    String address;
    String phone;
    ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min,double max){
        inventory.sort(Comparator.comparing(Vehicle::getPrice));
        ArrayList<Vehicle> vehiclesInPriceRange = new ArrayList<>();
        for( Vehicle v : inventory){
            if(v.getPrice() >= min && v.getPrice() <= max)
                vehiclesInPriceRange.add(v);
        }

        return vehiclesInPriceRange;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        inventory.sort(Comparator.comparing(Vehicle::getMake));
        ArrayList<Vehicle> output = new ArrayList<>();
        for( Vehicle v : inventory){
            if( v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model))
                output.add(v);
        }

        return output;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        inventory.sort(Comparator.comparing(Vehicle::getYear));
        ArrayList<Vehicle> output = new ArrayList<>();
        for( Vehicle v : inventory){
            if ( v.getYear() >= min && v.getYear()<= max )
                output.add(v);
        }

        return output;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        inventory.sort(Comparator.comparing(Vehicle::getColor));
        ArrayList<Vehicle> output = new ArrayList<>();
        for( Vehicle v : inventory){
            if (v.getColor().equalsIgnoreCase(color))
                output.add(v);
        }
        return output;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        inventory.sort(Comparator.comparing(Vehicle::getOdometer));
        ArrayList<Vehicle> output = new ArrayList<>();
        for( Vehicle v : inventory){
            if (v.getOdometer() >= min && v.getOdometer()<= max )
                output.add(v);
        }

        return output;
    }

    public List<Vehicle> getVehiclesByType(String type){
        inventory.sort(Comparator.comparing(Vehicle::getVehicleType));
        ArrayList<Vehicle> output = new ArrayList<>();
        for( Vehicle v : inventory){
            if (v.getVehicleType().equalsIgnoreCase(type))
                output.add(v);
        }
        return output;
    }

    public Vehicle getByVIN (int vin){
        for (Vehicle v : inventory) {
            if ( v.getVin() == vin)
                return v;
        }
        System.out.println("Vehicle not found.");
        return null;
    }

    public void addVehicle(Vehicle newVehicle) throws IOException {
        if( inventory.add(newVehicle) ) {
            System.out.println("Vehicle added successfully.");
            DealershipFileManager.saveDealearship(this);
        }
        else
            System.out.println("Unable to add specified vehicle.");
    }

    public void removeVehicle(Vehicle vehicleToRemove) throws IOException {
        if(inventory.contains(vehicleToRemove)) {
            inventory.remove(vehicleToRemove);
            System.out.println("Removed successfully");
            DealershipFileManager.saveDealearship(this);
        }
        else
            System.out.println("Unable to remove");
    }

    public void sellVehicle(String name, String email, Vehicle vehicleSold,boolean isFinanced) throws IOException {
        String date = LocalDate.now().toString();
        Contract sale = new SalesContract(date,name,email,vehicleSold,isFinanced);
        ContractFileManager.addContract(sale);
        inventory.remove(vehicleSold);
        DealershipFileManager.saveDealearship(this);
    }

    public void leaseVehicle(String name, String email, Vehicle vehicleSold) throws IOException {
        String date = LocalDate.now().toString();
        Contract lease = new LeaseContract(date,name,email,vehicleSold);
        ContractFileManager.addContract(lease);
        inventory.remove(vehicleSold);
        DealershipFileManager.saveDealearship(this);
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    @Override
    public String toString(){

        return String.format("%s|%s|%s",name,address,phone);
    }
}
