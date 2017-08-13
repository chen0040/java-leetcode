# link: https://leetcode.com/problems/word-frequency/description/
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'
