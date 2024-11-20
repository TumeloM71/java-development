
SELECT ProductID, ProductName, UnitPrice, CategoryName, CompanyName AS Supplier 
FROM northwind.products AS p

JOIN northwind.categories AS c
ON p.CategoryID = c.CategoryID

JOIN northwind.suppliers AS s
ON p.SupplierID = s.SupplierID

WHERE UnitPrice = (SELECT MAX(UnitPrice) AS MaxPrice FROM northwind.products);
