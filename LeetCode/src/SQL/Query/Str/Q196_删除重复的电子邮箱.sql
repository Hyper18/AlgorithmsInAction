DELETE
FROM Person
WHERE id NOT IN (SELECT *
                 FROM (SELECT min(p1.id)
                       FROM Person p1
                       GROUP BY p1.email) p2)