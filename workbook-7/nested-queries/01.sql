SELECT ProductName, UnitPrice FROM northwind.products
WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM northwind.products);