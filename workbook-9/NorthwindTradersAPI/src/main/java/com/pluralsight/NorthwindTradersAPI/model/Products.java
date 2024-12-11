package com.pluralsight.NorthwindTradersAPI.model;

import jakarta.persistence.*;

@Entity
public class Products {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)int ProductId;
    @Column private String ProductName;
    @Column private int CategoryID;
    @Column private double UnitPrice;

    public int getProductId() {
        return ProductId;
    }


    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Products{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                ", CategoryID=" + CategoryID +
                ", UnitPrice=" + UnitPrice +
                '}';
    }
}
