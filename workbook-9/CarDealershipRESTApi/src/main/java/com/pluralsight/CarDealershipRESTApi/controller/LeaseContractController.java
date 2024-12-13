package com.pluralsight.CarDealershipRESTApi.controller;


import com.pluralsight.CarDealershipRESTApi.models.LeaseContract;
import com.pluralsight.CarDealershipRESTApi.models.SaleContract;
import com.pluralsight.CarDealershipRESTApi.repository.LeaseContractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LeaseContractController {

    private LeaseContractDAO leaseContractDAO;

    @Autowired
    public LeaseContractController(LeaseContractDAO leaseContractDAO){
        this.leaseContractDAO = leaseContractDAO;
    }

    @Transactional
    @GetMapping("/leases")
    public List<LeaseContract> getAll(){

        return leaseContractDAO.findAll();
    }

    @Transactional
    @GetMapping("/leases/{id}")
    public ResponseEntity<LeaseContract> getById(@PathVariable("id") int id){

        Optional<LeaseContract> optionalLeaseContract = leaseContractDAO.findById(id);

        if (optionalLeaseContract.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(optionalLeaseContract.get());
    }

    @Transactional
    @PostMapping("/leases")
    public ResponseEntity<LeaseContract> add(@RequestBody LeaseContract leaseContract){

        leaseContractDAO.save(leaseContract);
        return ResponseEntity.status(HttpStatus.OK).body(leaseContract);
    }

    @Transactional
    @PutMapping("leases/{id}")
    public ResponseEntity<LeaseContract> update(@PathVariable("id") int id, @RequestBody LeaseContract leaseContract){

        Optional<LeaseContract> optionalLeaseContract = leaseContractDAO.findById(id);

        if (optionalLeaseContract.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(leaseContract);

        LeaseContract foundContract = optionalLeaseContract.get();

        if (leaseContract.getLeasePrice() != 0)
            foundContract.setLeasePrice(leaseContract.getLeasePrice());

        if (leaseContract.getCustomerName() != null)
            foundContract.setCustomerName(leaseContract.getCustomerName());

        if (leaseContract.getLeaseStartDate() != null)
            foundContract.setLeaseStartDate(leaseContract.getLeaseStartDate());

        if (leaseContract.getLeaseEndDate() != null)
            foundContract.setLeaseEndDate(leaseContract.getLeaseEndDate());

        if (leaseContract.getVehicle() != null)
            foundContract.setVehicle(leaseContract.getVehicle());

        if (leaseContract.getDealership() != null)
            foundContract.setDealership(leaseContract.getDealership());

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/leases/{id}")
    public ResponseEntity<LeaseContract> delete(@PathVariable("id") int id){

        Optional<LeaseContract> optionalLeaseContract = leaseContractDAO.findById(id);

        if (optionalLeaseContract.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        leaseContractDAO.delete(optionalLeaseContract.get());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
