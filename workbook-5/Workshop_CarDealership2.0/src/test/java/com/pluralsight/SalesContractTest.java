package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {

    Vehicle sale = new Vehicle("10112|1993|Ford|Explorer|SUV|Red|525123|995.00");

    SalesContract salesContract = new SalesContract("2021:09:08","Dana Wyatt","dana@texas.com",sale, false);

    double expectedTotalPrice = 1439.75;
    double expectedMonthlyPayment = 0.00;
    double expectedSalesTax = 49.75;
    double expectedRecordFee = 100;
    double expectedProcessingFee = 295;

    @Test
    void getProcessingFee() {
        assertEquals(expectedProcessingFee,salesContract.getProcessingFee());
    }

    @Test
    void getRecordingFee() {
        assertEquals(expectedRecordFee,salesContract.getRecordingFee());
    }

    @Test
    void getSalesTax() {
        assertEquals(expectedSalesTax,salesContract.getSalesTax());
    }

    @Test
    void isFinanced() {
        assertFalse(salesContract.isFinanced());
    }

    @Test
    void getTotalPrice() {
        assertEquals(expectedTotalPrice,salesContract.getTotalPrice());
    }

    @Test
    void getMonthlyPayment() {
        assertEquals(expectedMonthlyPayment,salesContract.getMonthlyPayment());
    }

    @Test
    void testGetMonthlyPayment() {

    }
}