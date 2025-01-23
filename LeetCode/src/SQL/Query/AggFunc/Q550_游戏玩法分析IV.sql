WITH First AS (SELECT *
               FROM Activity
               WHERE (player_id, event_date) IN (SELECT player_id, MIN(event_date)
                                                 FROM Activity
                                                 GROUP BY player_id))
SELECT ROUND(COUNT(*) / (SELECT COUNT(*) FROM First), 2) AS fraction
FROM Activity a
         LEFT JOIN First f
                   ON a.player_id = f.player_id
WHERE f.event_date + interval 1 day = a.event_date