--link: https://leetcode.com/problems/duplicate-emails/description/
SELECT Email from Person group by Email having COUNT(*) > 1;
