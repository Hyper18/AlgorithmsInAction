-- 考察同时有多个排序因素时的处理
SELECT r.contest_id, ROUND(COUNT(*) / (SELECT COUNT(*) FROM Users) * 100, 2) AS percentage
FROM Users u,
     Register r
WHERE u.user_id = r.user_id
GROUP BY r.contest_id
ORDER BY percentage DESC, r.contest_id