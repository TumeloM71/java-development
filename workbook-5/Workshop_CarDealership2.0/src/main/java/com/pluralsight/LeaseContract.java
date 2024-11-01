package com.pluralsight;

public class LeaseContract extends Contract{

    double endValue;
    double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.endValue = vehicleSold.getPrice() * 0.5;
        this.leaseFee = vehicleSold.getPrice()  * 0.07;
    }

    public double getEndValue() {
        return endValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return getMonthlyPayment()*36;
    }

    @Override
    public double getMonthlyPayment(){
        double principal = endValue;
        int numOfMonths = 36;
        double monthlyRate = 0.04/12;
        return getMonthlyPayment(principal,numOfMonths,monthlyRate);
}

    public static double getMonthlyPayment ( double P, int N, double r)
{
    return (r * P * Math.pow(1 + r, N)) / (Math.pow(1 + r, N) - 1);
}

    public String toString(){
        return String.format("LEASE|%s|%s|%s|%s|$%.2f|$%.2f|$%.2f|$%.2f",
                date,customerName,customerEmail,vehicleSold,endValue,leaseFee,
                getMonthlyPayment(),getTotalPrice());
    }
}
