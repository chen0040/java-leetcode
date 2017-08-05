-- link: https://leetcode.com/problems/classes-more-than-5-students/description/
-- summary: Please list out all classes which have more than or equal to 5 students.
SELECT class FROM courses GROUP BY class having COUNT(distinct student) >= 5;
