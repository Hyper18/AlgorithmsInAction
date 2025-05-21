-- 开窗函数的使用
SELECT Department, Employee, Salary
FROM (SELECT d.name       Department,
             e.name       Employee,
             salary       Salary,
             DENSE_RANK() over (PARTITION BY d.name ORDER BY Salary DESC) r
      FROM Department d,
           Employee e
      WHERE d.id = e.departmentId) t1
WHERE r <= 3