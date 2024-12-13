package com.pluralsight.CarDealershipRESTApi.controller;

import com.pluralsight.CarDealershipRESTApi.models.Dealership;
import com.pluralsight.CarDealershipRESTApi.repository.DealershipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DealershipController {

    private DealershipDAO dealershipDAO;

    @Autowired
    public DealershipController(DealershipDAO dealershipDAO){
        this.dealershipDAO =dealershipDAO;
    }

    @Transactional
    @GetMapping("/dealerships")
    public List<Dealership> getAll(){

        return dealershipDAO.findAll();
    }

    @Transactional
    @GetMapping("/dealerships/{id}")
    public ResponseEntity<Dealership> getById(@PathVariable("id") int id){

        Optional<Dealership> optionalDealership = dealershipDAO.findById(id);

        if (!optionalDealership.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        else
            return ResponseEntity.status(HttpStatus.OK).body(optionalDealership.get());
    }

    @Transactional
    @PostMapping("/dealerships")
    public ResponseEntity<Dealership> add(@RequestBody Dealership dealership){

        dealershipDAO.save(dealership);
        return ResponseEntity.status(HttpStatus.OK).body(dealership);

    }

    @Transactional
    @PutMapping("dealerships/{id}")
    public ResponseEntity<Dealership> update(@PathVariable("id") int id, @RequestBody Dealership dealership){

        Optional<Dealership> optionalDealership = dealershipDAO.findById(id);

        if (optionalDealership.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dealership);

        Dealership foundDealership = optionalDealership.get();
        if (dealership.getAddress() != null)
            foundDealership.setAddress(dealership.getAddress());

        if (dealership.getName() != null)
            foundDealership.setName(dealership.getName());

        if (dealership.getPhone() != null)
            foundDealership.setPhone(dealership.getPhone());

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Transactional
    @DeleteMapping("/dealerships/{id}")
    public ResponseEntity<Dealership> delete (@RequestBody Dealership dealership){

        dealershipDAO.delete(dealership);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
