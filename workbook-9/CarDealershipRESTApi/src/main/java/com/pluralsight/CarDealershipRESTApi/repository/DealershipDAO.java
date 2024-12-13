package com.pluralsight.CarDealershipRESTApi.repository;

import com.pluralsight.CarDealershipRESTApi.models.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealershipDAO extends JpaRepository<Dealership, Integer> {
}
