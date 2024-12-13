package com.pluralsight.CarDealershipRESTApi.controller;

import com.pluralsight.CarDealershipRESTApi.models.Vehicle;
import com.pluralsight.CarDealershipRESTApi.repository.VehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {

    private VehicleDAO vehicleDAO;

    @Autowired
    public VehicleController(VehicleDAO vehicleDAO){
        this.vehicleDAO = vehicleDAO;
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAll(){

        return vehicleDAO.findAll();
    }

    @GetMapping("/vehicles/{VIN}")
    public ResponseEntity<Vehicle> getByVIN(@PathVariable("VIN") String VIN){

        Optional<Vehicle> optionalVehicle = vehicleDAO.findById(VIN);

        if (optionalVehicle.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(optionalVehicle.get());
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> add(@RequestBody Vehicle vehicle){

        vehicleDAO.save(vehicle);
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }

    @PutMapping("/vehicles/{VIN}")
    public ResponseEntity<Vehicle> update(@PathVariable("VIN") String VIN, @RequestBody Vehicle vehicle){

         Optional<Vehicle> optionalVehicle = vehicleDAO.findById(VIN);

         if (optionalVehicle.isEmpty())
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vehicle);

         Vehicle existingVehicle = optionalVehicle.get();

         if (vehicle.getMake() != null)
             existingVehicle.setMake(vehicle.getMake());

         if (vehicle.getModel() != null)
             existingVehicle.setModel(vehicle.getModel());

         if (vehicle.getPrice() != 0)
             existingVehicle.setPrice(vehicle.getPrice());

         if (vehicle.getMileage() != 0)
             existingVehicle.setMileage(vehicle.getMileage());

         if (vehicle.getColor() != null)
             existingVehicle.setColor(vehicle.getColor());

         if (vehicle.getType() != null)
             existingVehicle.setType(vehicle.getType());

         if (vehicle.getSold() != 0)
             existingVehicle.setSold(0);

         if (vehicle.getYear() != 0)
             existingVehicle.setYear(vehicle.getYear());

         vehicleDAO.save(existingVehicle);

         return ResponseEntity.status(HttpStatus.OK).body(existingVehicle);
    }

    @DeleteMapping("/vehicles/{VIN}")
    public ResponseEntity<Vehicle> delete(@PathVariable("VIN") String VIN){

        Optional<Vehicle> optionalVehicle = vehicleDAO.findById(VIN);

        if (optionalVehicle.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        vehicleDAO.delete(optionalVehicle.get());

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
