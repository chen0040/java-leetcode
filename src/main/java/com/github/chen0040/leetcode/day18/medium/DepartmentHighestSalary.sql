--link: https://leetcode.com/problems/department-highest-salary/description/

SELECT D.Name as Department, A.Name as Employee, A.Salary
FROM
	Employee A,
	Department D
WHERE A.DepartmentId = D.Id
  AND NOT EXISTS
  (SELECT 1 FROM Employee B WHERE B.Salary > A.Salary AND A.DepartmentId = B.DepartmentId)
