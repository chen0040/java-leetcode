-- link: https://leetcode.com/problems/nth-highest-salary/description/
-- summary:
-- Write a SQL query to get the nth highest salary from the Employee table.
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary from Employee ORDER BY Salary DESC LIMIT M, 1
  );
END
