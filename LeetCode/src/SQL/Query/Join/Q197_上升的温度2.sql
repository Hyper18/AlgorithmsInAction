-- 主要考察了日期的处理，这里WHERE是隐式的INNER JOIN
SELECT w1.id
FROM Weather w1,
     Weather w2
WHERE w1.recordDate - interval 1 day = w2.recordDate AND w1.temperature > w2.temperature