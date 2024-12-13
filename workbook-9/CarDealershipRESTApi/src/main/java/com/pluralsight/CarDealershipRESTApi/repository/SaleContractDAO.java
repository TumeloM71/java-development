package com.pluralsight.CarDealershipRESTApi.repository;

import com.pluralsight.CarDealershipRESTApi.models.SaleContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleContractDAO extends JpaRepository<SaleContract, Integer> {
}
