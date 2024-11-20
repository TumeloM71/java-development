SELECT OrderID, ShipName, ShipAddress, CompanyName 
FROM northwind.orders AS o
JOIN northwind.shippers AS s
ON o.ShipVia = s.ShipperID
WHERE o.ShipCountry LIKE 'Germany';