--link: https://leetcode.com/problems/rising-temperature/description/
--Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
SELECT w1.ID from Weather w1, Weather w2 where DATEDIFF(w1.Date, w2.Date) = 1 && w1.Temperature > w2.Temperature;
