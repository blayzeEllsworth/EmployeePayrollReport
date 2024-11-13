USE ClassicModels;

SELECT e.firstName, e.lastName
FROM Employees e
LEFT JOIN Customers c on e.employeeNumber = c.salesRepEmployeeNumber
LEFT JOIN Orders o ON o.customerNumber = c.customerNumber
WHERE jobTitle = "Sales Rep" AND customerName IS NULL;