SELECT ProductID, ProductName, UnitPrice, UnitsInStock, UnitsOnOrder 
FROM northwind.products
WHERE UnitsInStock = 0 AND UnitsOnOrder >= 1;