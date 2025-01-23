-- 很绕的一道题，想了很久
WITH t AS (SELECT product_id, MAX(change_date) change_date
           FROM Products
           WHERE change_date <= '2019-08-16'
           GROUP BY product_id)
SELECT DISTINCT p.product_id, IF(t.product_id IS NULL, 10, new_price) price
FROM Products p
         LEFT JOIN t
                   ON p.product_id = t.product_id
WHERE p.change_date = t.change_date
   OR p.product_id NOT IN (IFNULL(t.product_id, 0))