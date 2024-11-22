USE `car dealerships`;

SELECT d.name, v.* FROM inventory i 
JOIN vehicles v 
ON v.VIN = i.VIN
JOIN dealerships d
ON i.dealership_id = d.dealership_id
WHERE d.name = 'Best Auto Deals';