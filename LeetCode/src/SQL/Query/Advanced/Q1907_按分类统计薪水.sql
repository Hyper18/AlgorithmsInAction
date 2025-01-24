-- union的使用
SELECT 'Low Salary' category, SUM(income < 20000) accounts_count
FROM accounts
UNION
SELECT 'Average Salary', SUM(income BETWEEN 20000 AND 50000)
FROM accounts
UNION
SELECT 'High Salary', SUM(income > 50000)
FROM accounts