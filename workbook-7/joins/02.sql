SELECT ProductID, ProductName, UnitPrice, CompanyName
FROM northwind.products AS p
JOIN northwind.suppliers AS s
ON p.SupplierID = s.SupplierID
WHERE UnitPrice > 75
ORDER BY ProductName;