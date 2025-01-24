-- 窗口函数
SELECT DISTINCT visited_on, total amount, ROUND(total / 7, 2) average_amount
FROM (SELECT visited_on, SUM(amount) OVER(ORDER BY visited_on ROWS 6 PRECEDING) total
      FROM (SELECT visited_on, SUM(amount) amount
            FROM Customer
            GROUP BY visited_on) tt) t
WHERE DATEDIFF(visited_on, (SELECT MIN(visited_on) FROM Customer)) >= 6