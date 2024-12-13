package com.pluralsight.CarDealershipRESTApi.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class LeaseContract {

    @Id
    @Column(name = "leaseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "VIN")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "dealership_id", referencedColumnName = "dealership_id")
    private Dealership dealership;

    @Column
    private String customerName;

    @Column
    private double leasePrice;

    @Column
    private Date leaseStartDate;

    @Column
    private Date LeaseEndDate;

    public LeaseContract() {
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

    public String getCustomerName() {
        return this.customerName;
    }

    public double getLeasePrice() {
        return this.leasePrice;
    }

    public Date getLeaseStartDate() {
        return this.leaseStartDate;
    }

    public Date getLeaseEndDate() {
        return this.LeaseEndDate;
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

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setLeasePrice(double leasePrice) {
        this.leasePrice = leasePrice;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public void setLeaseEndDate(Date LeaseEndDate) {
        this.LeaseEndDate = LeaseEndDate;
    }

    public String toString() {
        return "LeaseContract(id=" + this.getId() + ", vehicle=" + this.getVehicle() + ", dealership=" + this.getDealership() + ", customerName=" + this.getCustomerName() + ", leasePrice=" + this.getLeasePrice() + ", leaseStartDate=" + this.getLeaseStartDate() + ", LeaseEndDate=" + this.getLeaseEndDate() + ")";
    }
}
