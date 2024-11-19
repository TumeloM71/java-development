SELECT SupplierID, COUNT(*) AS NumOfProducts FROM northwind.products
GROUP BY SupplierID;