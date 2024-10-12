package com.pluralsight;

import java.util.Objects;

/*
SKU|Product Name|Price|Department
AV1051|JBL Bluetooth Speaker|89.95|Audio Video
AV1312|Mini 1000 Lumens Projector|149.95|Audio Video
GM1148|Retro Handheld Arcade|24.45|Games
PW1001|Solar Powered Battery Charger|19.99|Electronics
...
 */
public class Product {
    private String SKU ;
    private String productName;
    private double price;
    String department;

    public Product(String SKU, String productName, double price, String department) {
        this.SKU = SKU;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getSKU() {
        return SKU;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Product{" +
                "SKU='" + SKU + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getSKU(), product.getSKU()) && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getDepartment(), product.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSKU(), getProductName(), getPrice(), getDepartment());
    }
}
