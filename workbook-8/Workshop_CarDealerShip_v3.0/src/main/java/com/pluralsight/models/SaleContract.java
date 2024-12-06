package com.pluralsight.models;

import java.sql.Date;

public record SaleContract(int id, String VIN, int dealershipId, String customerName, double salePrice, Date saleDate) {
}
