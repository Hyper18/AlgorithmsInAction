-- 优化，coalesce的使用
SELECT DISTINCT p1.product_id,
                COALESCE((SELECT p2.new_price
                          FROM Products p2
                          WHERE p2.product_id = p1.product_id
                            AND p2.change_date <= '2019-08-16'
                          ORDER BY p2.change_date DESC
                         limit 1), 10) price
from Products p1