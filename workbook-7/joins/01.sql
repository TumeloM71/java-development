SELECT ProductID, ProductName, UnitPrice, SupplierID, CategoryName
FROM northwind.products AS p
LEFT JOIN northwind.categories AS c
ON p.CategoryID = c.categoryID
ORDER BY CategoryName, ProductName;