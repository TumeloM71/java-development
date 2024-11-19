SELECT CategoryID, AVG(UnitPrice) AS AveragePrice FROM northwind.products
GROUP BY CategoryID;