-- 主要考察了日期的处理
SELECT w1.id
FROM Weather w1
         LEFT JOIN Weather w2
                   ON datediff(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature