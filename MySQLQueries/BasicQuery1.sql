USE ClassicModels;

SELECT c.customerName, o.status, COUNT(o.orderNumber) AS DistinctOrders
FROM Customers c
JOIN Orders o ON o.customerNumber = c.customerNumber
GROUP BY c.customerName, o.status
ORDER BY DistinctOrders DESC; 
							

