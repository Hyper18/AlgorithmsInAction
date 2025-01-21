-- 这题的坑在于如果直接先分组再max()得到的是每一个只出现一次的值，因为按照num分组后相当于取得是每组的最大值
SELECT MAX(num) AS num
FROM MyNumbers
WHERE num IN (SELECT num
              FROM MyNumbers
              GROUP BY num
              HAVING COUNT(num) = 1)