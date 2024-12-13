package com.pluralsight.CarDealershipRESTApi.repository;

import com.pluralsight.CarDealershipRESTApi.models.LeaseContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseContractDAO extends JpaRepository<LeaseContract, Integer> {
}
