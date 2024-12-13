package com.pluralsight.CarDealershipRESTApi.models;

import jakarta.persistence.*;

@Entity
@Table
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @OneToOne
    @JoinColumn(name = "VIN", referencedColumnName = "VIN", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "dealership_id", referencedColumnName = "dealership_id", nullable = false)
    private Dealership dealership;

    public Inventory() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", dealership=" + dealership +
                '}';
    }
}
