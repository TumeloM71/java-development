USE northwind;

SELECT ProductName, CompanyName AS Supplier FROM products AS p
JOIN suppliers AS s 
ON p.SupplierID = s.SupplierID;