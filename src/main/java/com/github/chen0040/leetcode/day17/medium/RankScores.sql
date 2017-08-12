--link: https://leetcode.com/problems/rank-scores/description/
select Score, (SELECT Count(DISTINCT Score) from Scores WHERE Score >= s.Score) as Rank from Scores s order by Score DESC;
