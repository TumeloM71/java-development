USE northwind;

SELECT ContactName
FROM customers
WHERE CustomerID = (SELECT CustomerID FROM orders WHERE OrderID = 10266);