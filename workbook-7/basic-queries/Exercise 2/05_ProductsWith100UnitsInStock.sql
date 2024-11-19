SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM northwind.products
WHERE UnitsInStock <= 100
ORDER BY UnitPrice DESC;