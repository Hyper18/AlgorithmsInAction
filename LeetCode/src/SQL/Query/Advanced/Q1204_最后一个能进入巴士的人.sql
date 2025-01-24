-- 出现累加，考虑使用窗口函数
WITH t AS (SELECT person_name, SUM(weight) OVER(ORDER BY turn) total
           FROM Queue)
SELECT person_name
FROM t
WHERE total <= 1000
ORDER BY total DESC LIMIT 1