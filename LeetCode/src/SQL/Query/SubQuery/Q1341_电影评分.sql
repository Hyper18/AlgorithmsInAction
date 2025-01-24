WITH res1 AS (SELECT name, COUNT(*) total
              FROM MovieRating m,
                   Users u
              WHERE m.user_id = u.user_id
              GROUP BY m.user_id
              ORDER BY total DESC, name
    LIMIT 1)
   , res2 AS (
SELECT title, AVG (rating) avg_rating
FROM MovieRating m1, Movies m2
WHERE m1.movie_id = m2.movie_id
  AND created_at BETWEEN '2020-02-01'
  AND '2020-02-29'
GROUP BY m1.movie_id
ORDER BY avg_rating DESC, title
    LIMIT 1)
SELECT name results
FROM res1
UNION ALL
SELECT title
FROM res2