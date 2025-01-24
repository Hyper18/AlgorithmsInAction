-- 第一次用，group_concat
SELECT sell_date,
       COUNT(DISTINCT product)                                          num_sold,
       GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',') AS products
FROM Activities
GROUP BY sell_date
ORDER BY sell_date