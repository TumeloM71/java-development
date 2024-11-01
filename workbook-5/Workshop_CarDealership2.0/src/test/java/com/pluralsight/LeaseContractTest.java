package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LeaseContractTest {
    Vehicle lease = new Vehicle("37847|2021|Chevrolet|Silverado|truck|Black|2750|31995.00");
    Vehicle secondLease = new Vehicle("79900|2022|Dodge|Challenger|muscle car|black|25000|28000.00");
    LeaseContract leaseContract = new LeaseContract("2021:09:28","Zachary Westly",
            "texas.com",secondLease);

    double endValueEx = 14000;
    double leaseFeeEx = 1960;
    double totalPriceEx = 15732;
    double monthlyPaymentEx = 437;

    @Test
    void getEndValue() {
        assertEquals(endValueEx,leaseContract.getEndValue());
    }

    @Test
    void getLeaseFee() {
        assertEquals(leaseFeeEx,leaseContract.getLeaseFee(),0.005);
    }

    @Test
    void getTotalPrice() {
        assertEquals(totalPriceEx,leaseContract.getTotalPrice(), 1000);
    }

    @Test
    void getMonthlyPayment() {
        assertEquals(monthlyPaymentEx,leaseContract.getMonthlyPayment(), 100);
    }
}