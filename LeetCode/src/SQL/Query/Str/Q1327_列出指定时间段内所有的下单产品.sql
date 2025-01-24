SELECT product_name, SUM(unit) unit
FROM Products p,
     Orders o
WHERE p.product_id = o.product_id
  AND order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY product_name
HAVING unit >= 100