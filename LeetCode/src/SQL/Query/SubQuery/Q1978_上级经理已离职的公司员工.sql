SELECT e1.employee_id
FROM Employees e1
WHERE salary < 30000
  AND e1.manager_id IS NOT NULL
  AND e1.manager_id NOT IN (SELECT e2.employee_id
                            FROM Employees e2
                            WHERE e2.employee_id = e1.manager_id)
ORDER BY e1.employee_id