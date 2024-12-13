package com.pluralsight.CarDealershipRESTApi.models;

import jakarta.persistence.*;

@Entity
@Table
public class Dealership {

    @Id
    @Column(name = "dealership_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dealershipId;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    public Dealership() {
    }

    public int getDealershipId() {
        return this.dealershipId;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Dealership(dealershipId=" + this.getDealershipId() + ", name=" + this.getName() + ", address=" + this.getAddress() + ", phone=" + this.getPhone() + ")";
    }
}
