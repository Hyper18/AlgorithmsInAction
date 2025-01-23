-- partition的使用
SELECT DISTINCT t.num AS ConsecutiveNums
FROM (SELECT id, num, CAST(row_number() OVER(PARTITION BY num ORDER BY id) AS SIGNED) AS rn
      FROM Logs
      ORDER BY num, id) t
GROUP BY t.num, t.id - t.rn
HAVING COUNT(t.id - t.rn) >= 3