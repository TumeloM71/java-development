USE `car dealerships`;

SELECT d.name, s.* FROM sales_contracts s 
JOIN dealerships d
ON s.dealership_id = d.dealership_id
WHERE s.sale_date LIKE '2024%' AND d.dealership_id = 1;