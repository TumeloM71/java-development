USE `car dealerships`;

SELECT * FROM vehicles WHERE 
VIN = (SELECT MIN(VIN) FROM inventory); 