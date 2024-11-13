USE ClassicModels;

/*What is the name of the product(s) of type Trains that has been sold, whose average
 price that it has been sold at (priceEach) is more than twice its buyPrice. 
 */
SELECT p.productName
FROM Products p
JOIN OrderDetails od ON p.productCode = od.productCode
WHERE p.productLine = 'Trains'
GROUP BY p.productName, p.buyPrice
HAVING AVG(od.priceEach) > 2 * p.buyPrice;


/*Which is/are the non-USA country(ies) whose customers have written more than
 1 check where the amount on the check(s) is greater than 45,000 dollars?
 */
SELECT c.country, COUNT(p.checkNumber) AS numberOfChecks
FROM Payments p
JOIN Customers c ON p.customerNumber = c.customerNumber
WHERE p.amount > 45000
GROUP BY c.country
HAVING COUNT(p.checkNumber) > 1 AND c.country != 'USA';

/*Which is/are the non-USA country(ies) whose customers have written more than
 1 check where the amount on the check(s) is greater than 70,000 dollars?
 */
SELECT c.country, COUNT(p.checkNumber) AS numberOfChecks
FROM Payments p
JOIN Customers c ON p.customerNumber = c.customerNumber
WHERE p.amount > 70000
GROUP BY c.country
HAVING COUNT(p.checkNumber) > 1 AND c.country != 'USA';
