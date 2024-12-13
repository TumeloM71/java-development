package com.pluralsight.CarDealershipRESTApi.controller;

import com.pluralsight.CarDealershipRESTApi.models.Dealership;
import com.pluralsight.CarDealershipRESTApi.models.Inventory;
import com.pluralsight.CarDealershipRESTApi.repository.InventoryDAO;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {

    InventoryDAO inventoryDAO;

    @Autowired
    public InventoryController(InventoryDAO inventoryDAO){
        this.inventoryDAO = inventoryDAO;
    }


    @Transactional
    @GetMapping("/inventory")
    public List<Inventory> getAll(){

        return inventoryDAO.findAll();
    }

    @Transactional
    @GetMapping("/inventory/{id}")
    public ResponseEntity<Inventory> getById(@PathVariable("id") int id){

        Optional<Inventory> optionalInventory = inventoryDAO.findById(id);

        if (optionalInventory.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(optionalInventory.get());
    }

    @Transactional
    @PostMapping("/inventory")
    public ResponseEntity<Inventory> add(@RequestBody Inventory inventory){

        inventoryDAO.save(inventory);
        return ResponseEntity.status(HttpStatus.OK).body(inventory);
    }

    @Transactional
    @PutMapping("inventory/{id}")
    public ResponseEntity<Inventory> update(@PathVariable("id") int id, @RequestBody Inventory inventory){

        Optional<Inventory> optionalInventory = inventoryDAO.findById(id);

        if (optionalInventory.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(inventory);

        Inventory foundInventory = optionalInventory.get();
        if (inventory.getDealership() != null)
            foundInventory.setDealership(inventory.getDealership());

        if (inventory.getVehicle() != null)
            foundInventory.setVehicle(inventory.getVehicle());

        inventoryDAO.save(foundInventory);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Transactional
    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<Inventory> delete (@PathVariable("id") int id){

        Optional<Inventory> optionalInventory = inventoryDAO.findById(id);
        System.out.println(optionalInventory);

        if (optionalInventory.isPresent()) {
            inventoryDAO.delete(optionalInventory.get());
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        else
            return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
