USE ClassicModels;

/*What is the total sales amount for each sales representative, and what is their commission 
based on sales performance, with a special rule for high sales (greater than $500,000)? A high sale gets 
a 12% commission and a regular sale will get a 10% commission.
*/
SELECT 
    e.firstName,
    e.lastName,
    ROUND(SUM(od.priceEach * od.quantityOrdered), 2) AS totalSales,
	CASE 
        WHEN SUM(od.priceEach * od.quantityOrdered) > 500000 THEN 
            ROUND(SUM(od.priceEach * od.quantityOrdered) * 0.12, 2) #12% commission 
        ELSE 
            ROUND(SUM(od.priceEach * od.quantityOrdered) * 0.10, 2) #10% commission 
    END AS commission
FROM Employees e
JOIN Customers c ON e.employeeNumber = c.salesRepEmployeeNumber
JOIN Orders o ON c.customerNumber = o.customerNumber
JOIN OrderDetails od ON o.orderNumber = od.orderNumber
GROUP BY e.employeeNumber
ORDER BY totalSales DESC;


/*What is the payment status (Good Standing or At Risk) of each customer 
based on whether their total payments are equal to or greater than their total orders?
*/
WITH CustomerOrders AS (
    SELECT 
        c.customerNumber,
        c.customerName,
        SUM(od.priceEach * od.quantityOrdered) AS totalOrderAmount
    FROM Customers c
    JOIN Orders o ON c.customerNumber = o.customerNumber
    JOIN OrderDetails od ON o.orderNumber = od.orderNumber
    GROUP BY c.customerNumber, c.customerName),
    #Temporary table setup created by using "With"
CustomerPayments AS (
    SELECT 
        c.customerNumber,
        SUM(p.amount) AS totalPayments
    FROM Customers c
    JOIN Payments p ON c.customerNumber = p.customerNumber
    GROUP BY c.customerNumber
)
SELECT 
    co.customerName,
    ROUND(co.totalOrderAmount, 2) AS totalOrderAmount,
    ROUND(cp.totalPayments, 2) AS totalPayments,
    ROUND(abs(totalOrderAmount - totalPayments), 2) AS balanceDue,
    CASE 
        WHEN cp.totalPayments >= co.totalOrderAmount THEN 'Good Standing'
        ELSE 'At Risk'
    END AS paymentStatus
FROM CustomerOrders co
JOIN CustomerPayments cp ON co.customerNumber = cp.customerNumber
ORDER BY balanceDue DESC;

