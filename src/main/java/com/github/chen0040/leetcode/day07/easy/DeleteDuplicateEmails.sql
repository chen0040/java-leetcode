-- Write your MySQL query statement below
-- link: https://leetcode.com/problems/delete-duplicate-emails/description/
DELETE p1 FROM Person p1, Person p2 WHERE p1.Email = p2.Email and p1.Id > p2.Id;
