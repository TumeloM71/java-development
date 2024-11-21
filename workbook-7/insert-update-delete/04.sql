USE northwind;

UPDATE products
SET UnitPrice = UnitPrice*1.15
WHERE ProductID LIKE (SELECT ProductID WHERE ProductName LIKE 'Philly Cheese Steak');

SELECT * WHERE ProductName LIKE 'Philly Cheese Steak';