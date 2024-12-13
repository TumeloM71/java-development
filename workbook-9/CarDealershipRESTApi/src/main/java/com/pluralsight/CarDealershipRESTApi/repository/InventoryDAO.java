package com.pluralsight.CarDealershipRESTApi.repository;

import com.pluralsight.CarDealershipRESTApi.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDAO extends JpaRepository<Inventory, Integer> {

}
