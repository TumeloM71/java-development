USE northwind;

SELECT od.OrderID, o.OrderDate, o.ShipName, o.ShipAddress, p.ProductName
FROM `order details`AS od 

JOIN orders AS o
ON o.OrderId = od.OrderID

JOIN products AS p 
ON p.ProductID = od.ProductID

WHERE p.ProductName LIKE 'Sasquatch Ale';
