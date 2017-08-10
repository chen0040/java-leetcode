-- link: https://leetcode.com/problems/exchange-seats/description/
-- Not sure the solution below works
select t1.id as id, coalesce(t2.student, t1.student) as student from seat t1 left join seat t2 on ((t1.id+1)^1)-1 = t2.id order by t1.id asc;

