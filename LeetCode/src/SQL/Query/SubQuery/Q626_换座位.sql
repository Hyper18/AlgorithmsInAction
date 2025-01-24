SELECT id + 1 id, student
FROM Seat
WHERE id & 1 = 1 AND id + 1 <= (SELECT MAX(id) FROM Seat)
UNION
SELECT id, student
FROM Seat
WHERE id & 1 = 1 AND id = (SELECT MAX(id) FROM Seat)
UNION
SELECT id - 1, student
FROM Seat
WHERE id & 1 = 0
ORDER BY id
