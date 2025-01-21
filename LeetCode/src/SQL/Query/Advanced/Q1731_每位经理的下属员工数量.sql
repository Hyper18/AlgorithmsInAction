-- 这样写两个子查询是很慢的
SELECT employee_id,
       name,
       (SELECT COUNT(*) FROM Employees e2 WHERE e2.reports_to = e1.employee_id)        AS reports_count,
       (SELECT ROUND(AVG(age)) FROM Employees e2 WHERE e2.reports_to = e1.employee_id) AS average_age
FROM Employees e1
GROUP BY employee_id
HAVING reports_count > 0
ORDER BY employee_id 