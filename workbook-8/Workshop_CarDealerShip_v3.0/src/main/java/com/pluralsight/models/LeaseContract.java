package com.pluralsight.models;

import java.sql.Date;

public record LeaseContract(int id, String VIN, int dealershipId, String customerName,
                            double leasePrice,
                            Date leaseStartDate, Date LeaseEndDate) {
}
