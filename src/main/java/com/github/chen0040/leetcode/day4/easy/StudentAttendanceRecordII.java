package com.github.chen0040.leetcode.day4.easy;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 * link: https://leetcode.com/problems/student-attendance-record-i/description/
 */
public class StudentAttendanceRecordII {
   public class Solution {
      public boolean checkRecord(String s) {
         int countA = 0;
         boolean countL = false;
         char prev = 'X';
         char prev2 = 'X';
         for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'A') {
               countA++;
            }
            if (c == 'L' && prev == 'L' && prev2 == 'L') {
               countL = true;
            }
            prev2 = prev;
            prev = c;
         }
         return countA < 2 && !countL;
      }
   }
}
