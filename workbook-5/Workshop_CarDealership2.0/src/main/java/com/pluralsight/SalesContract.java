package com.pluralsight;

public class SalesContract extends Contract{

    boolean isFinanced;
    double salesTax;
    double recordingFee;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
        salesTax = 0.05*vehicleSold.getPrice();
        recordingFee = 100;
    }

    public double getProcessingFee(){

        return vehicleSold.getPrice() >= 10000 ? 495.00 : 295.00;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    @Override
    public double getTotalPrice() {
         double originalPrice = vehicleSold.getPrice();
         double processingFee = getProcessingFee();
         double additionalCharges = salesTax+recordingFee+processingFee;
         if ( isFinanced && vehicleSold.getPrice() >=10000){
             return additionalCharges + 48*getMonthlyPayment();
         } else if (isFinanced && vehicleSold.getPrice()<10000) {
             return additionalCharges + 24*getMonthlyPayment();
         }
         else
             return additionalCharges+vehicleSold.getPrice();

    }

    @Override
    public double getMonthlyPayment() {
        if (isFinanced && this.vehicleSold.getPrice() >= 10000)
            return getMonthlyPayment(vehicleSold.getPrice(),48,0.0425/12);
        else if(isFinanced && this.vehicleSold.getPrice() < 10000)
            return getMonthlyPayment(vehicleSold.getPrice(), 24,0.0525/12);
        else
            return 0;
    }

//    Monthly payment is obtained with the following formula:
//    m = ( r*P*(1+r)^N )/( (1+r)^N - 1 )

    public static double getMonthlyPayment ( double P, int N, double r)
    {
        return (r * P * Math.pow(1 + r, N)) / (Math.pow(1 + r, N) - 1);
    }

    @Override
    public String toString(){

        return String.format("SALE|%s|%s|%s|%s|$%.2f|$%.2f|$%.2f|$%.2f|$%.2f",
                date,customerName,customerEmail,vehicleSold,
                getSalesTax(),getRecordingFee(),getProcessingFee(),
                getTotalPrice(),getMonthlyPayment());
    }

}
