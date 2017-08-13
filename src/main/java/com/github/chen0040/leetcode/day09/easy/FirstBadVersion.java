package com.github.chen0040.leetcode.day09.easy;


/**
 * Created by xschen on 4/8/2017.
 *
 * link: https://leetcode.com/problems/first-bad-version/description/
 */
public class FirstBadVersion {
   /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

   public class VersionControl {
      boolean isBadVersion(int version) {
         return false;
      }
   }

   public class Solution extends VersionControl {
      public int firstBadVersion(int n) {
         int lo = 1;
         int hi = n;
         while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(!isBadVersion(mid)) lo = mid + 1;
            else hi = mid;
         }
         return lo;
        /*
        int start = 1, end = n;
    while (start < end) {
        int mid = start + (end-start) / 2;
        if (!isBadVersion(mid)) start = mid + 1;
        else end = mid;
    }
    return start;*/
      }
   }
}
