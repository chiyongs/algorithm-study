SELECT c.*
FROM Cinema c
WHERE c.id % 2 = 1
AND c.description != 'boring'
ORDER BY c.rating desc;