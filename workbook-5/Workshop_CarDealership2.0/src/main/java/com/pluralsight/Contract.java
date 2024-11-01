package com.pluralsight;


//Abstract parent class for SalesContract and LeaseContract
public abstract class Contract {

    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicleSold;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.setDate(date);
        this.setCustomerName(customerName);
        this.setCustomerEmail(customerEmail);
        this.setVehicleSold(vehicleSold);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
