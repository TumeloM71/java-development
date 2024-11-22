USE `car dealerships` ;

SELECT d.name FROM inventory i 
JOIN vehicles v 
ON v.VIN = i.VIN
JOIN dealerships d
ON i.dealership_id = d.dealership_id
WHERE v.Make = 'Toyota';