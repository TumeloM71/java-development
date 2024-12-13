package com.pluralsight.CarDealershipRESTApi.controller;

import com.pluralsight.CarDealershipRESTApi.models.Inventory;
import com.pluralsight.CarDealershipRESTApi.models.SaleContract;
import com.pluralsight.CarDealershipRESTApi.models.Vehicle;
import com.pluralsight.CarDealershipRESTApi.repository.SaleContractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SaleContractController {

    private SaleContractDAO saleContractDAO;

    @Autowired
    public SaleContractController(SaleContractDAO saleContractDAO){
        this.saleContractDAO = saleContractDAO;
    }

    @Transactional
    @GetMapping("/sales")
    public List<SaleContract> getAll(){

        return saleContractDAO.findAll();
    }

    @Transactional
    @GetMapping("/sales/{id}")
    public ResponseEntity<SaleContract> getById(@PathVariable("id") int id){

        Optional<SaleContract> optionalSaleContract = saleContractDAO.findById(id);

        if (optionalSaleContract.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(optionalSaleContract.get());
    }

    @Transactional
    @PostMapping("/sales")
    public ResponseEntity<SaleContract> add(@RequestBody SaleContract saleContract){

        saleContractDAO.save(saleContract);
        return ResponseEntity.status(HttpStatus.OK).body(saleContract);
    }

    @Transactional
    @PutMapping("sales/{id}")
    public ResponseEntity<SaleContract> update(@PathVariable("id") int id, @RequestBody SaleContract saleContract){

        Optional<SaleContract> optionalSaleContract = saleContractDAO.findById(id);

        if (optionalSaleContract.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(saleContract);

        SaleContract foundContract = optionalSaleContract.get();

        if (saleContract.getSale_price() != 0)
            foundContract.setSale_price(saleContract.getSale_price());

        if (saleContract.getCustomer_name() != null)
            foundContract.setCustomer_name(saleContract.getCustomer_name());

        if (saleContract.getDate() != null)
            foundContract.setDate(saleContract.getDate());

        if (saleContract.getDealership() != null)
            foundContract.setDealership(saleContract.getDealership());

        if (saleContract.getVehicle() != null)
            foundContract.setVehicle(saleContract.getVehicle());

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<SaleContract> delete(@PathVariable("id") int id){

        Optional<SaleContract> optionalSaleContract = saleContractDAO.findById(id);

        if (optionalSaleContract.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        saleContractDAO.delete(optionalSaleContract.get());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
