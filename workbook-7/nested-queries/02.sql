SELECT OrderID, ShipName, ShipVia 
	FROM northwind.orders
		WHERE ShipVia = (SELECT ShipperID 
							FROM northwind.shippers
								WHERE CompanyName = "Federal Shipping");