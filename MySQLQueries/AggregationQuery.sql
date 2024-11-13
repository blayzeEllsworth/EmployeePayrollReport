USE ClassicModels;			  

/*Getting the product names for products that were purchased the most below the MSRP.
  The average difference between the MSRP and the purchase price of that product's product line.
  */
SELECT p.productName, p.productLine, ROUND((p.MSRP - p.buyPrice), 2) AS BelowMSRP, 
   ROUND(
           (SELECT AVG(ROUND((p2.MSRP - p2.buyPrice), 2))
            FROM Products p2
            WHERE p2.productLine = p.productLine), 
           2) AS AverageMSRPDifference
FROM Products p
WHERE p.MSRP - p.buyPrice > 
                           (SELECT AVG(p2.MSRP - p2.buyPrice)
                            FROM Products p2
                            WHERE p2.productLine = p.productLine
																)
GROUP BY p.productName, p.productLine, BelowMSRP
ORDER BY BelowMSRP DESC;
