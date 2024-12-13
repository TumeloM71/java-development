package com.pluralsight.CarDealershipRESTApi.models;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table
public class SaleContract {

    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "VIN", referencedColumnName = "VIN")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "dealership_id", referencedColumnName = "dealership_id")
    private Dealership dealership;

    @Column
    private String customer_name;

    @Column
    private double sale_price;

    @Column
    private Date date;

    public SaleContract() {
    }

    public int getId() {
        return this.id;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public Dealership getDealership() {
        return this.dealership;
    }

    public String getCustomer_name() {
        return this.customer_name;
    }

    public double getSale_price() {
        return this.sale_price;
    }

    public Date getDate() {
        return this.date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return "SaleContract(id=" + this.getId() + ", vehicle=" + this.getVehicle() + ", dealership=" + this.getDealership() + ", customer_name=" + this.getCustomer_name() + ", sale_price=" + this.getSale_price() + ", date=" + this.getDate() + ")";
    }
}
