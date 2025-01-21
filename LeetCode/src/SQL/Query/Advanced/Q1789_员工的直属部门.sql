SELECT e1.employee_id, e1.department_id
FROM Employee e1
WHERE e1.primary_flag = 'Y'
   OR (SELECT COUNT(*)
       FROM Employee e2
       GROUP BY e2.employee_id
       HAVING e1.employee_id = e2.employee_id) = 1