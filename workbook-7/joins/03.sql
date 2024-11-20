SELECT ProductID, ProductName, UnitPrice,
CategoryName AS Category, 
CompanyName AS Supplier
FROM northwind.products AS p
LEFT JOIN northwind.suppliers AS s
ON p.SupplierID = s.SupplierID
LEFT JOIN northwind.categories AS c
ON p.CategoryID = c.CategoryID
ORDER BY ProductName;