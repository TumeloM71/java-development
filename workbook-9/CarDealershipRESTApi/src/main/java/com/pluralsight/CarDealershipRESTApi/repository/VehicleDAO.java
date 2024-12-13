package com.pluralsight.CarDealershipRESTApi.repository;

import com.pluralsight.CarDealershipRESTApi.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle,  String> {
}
