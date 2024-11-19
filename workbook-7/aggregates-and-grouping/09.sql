SELECT ProductID, ProductName, UnitPrice*UnitsInStock AS InventoryValue 
FROM northwind.products
ORDER BY InventoryValue DESC, ProductName;