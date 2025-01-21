-- having的使用：用于对已经聚合的结果做进一步筛选
SELECT p.product_id, product_name
FROM Product p,
     Sales s
WHERE p.product_id = s.product_id
GROUP BY p.product_id
HAVING MAX(sale_date) <= '2019-03-31'
   AND MIN(sale_date) >= '2019-01-01'