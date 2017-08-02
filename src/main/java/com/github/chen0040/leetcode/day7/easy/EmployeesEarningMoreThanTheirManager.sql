-- link: https://leetcode.com/problems/employees-earning-more-than-their-managers/description/
-- The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.
-- Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.
SELECT E1.Name as Employee FROM Employee as E1, Employee as E2 where E1.ManagerId = E2.Id and E1.Salary > E2.Salary;
