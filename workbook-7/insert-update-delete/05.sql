SELECT ProductName, UnitPrice FROM northwind.products AS p
JOIN suppliers AS s 
ON p.SupplierID = s.SupplierID
WHERE s.SupplierID = (SELECT SupplierID FROM suppliers
						WHERE CompanyName = 'DELI-cious');