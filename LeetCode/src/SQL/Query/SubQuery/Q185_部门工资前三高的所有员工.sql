-- dense_rank窗口函数的使用
SELECT name Department, Employee, Salary
FROM (SELECT d.name,
             e.name       Employee,
             e.Salary,
             DENSE_RANK() OVER(PARTITION BY d.name ORDER BY e.salary DESC) r
      FROM Employee e,
           Department d
      WHERE e.departmentId = d.id) t
WHERE r <= 3