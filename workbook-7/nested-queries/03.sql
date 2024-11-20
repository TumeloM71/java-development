
USE northwind;

SELECT OrderID, ProductID
	FROM `order details`
		WHERE ProductId = (SELECT ProductID 
							FROM northwind.products
								WHERE ProductName = "Sasquatch Ale");


