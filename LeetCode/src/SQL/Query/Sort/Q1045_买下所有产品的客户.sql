SELECT customer_id
FROM Customer c,
     Product p
WHERE c.product_key = p.product_key
GROUP BY customer_id
HAVING COUNT(DISTINCT p.product_key) = (SELECT COUNT(*) FROM Product)