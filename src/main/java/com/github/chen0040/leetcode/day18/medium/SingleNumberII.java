package com.github.chen0040.leetcode.day18.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/single-number-ii/description/
 */
public class SingleNumberII {
   public class Solution {
      public int singleNumber(int[] nums) {
         Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
         for(int i=0; i < nums.length; ++i) {
            int num = nums[i];
            if(counts.containsKey(num)) {
               int count = counts.get(num) - 1;
               if(count == 0) {
                  counts.remove(num);
               } else {
                  counts.put(num, count);
               }
            } else {
               counts.put(num, 2);
            }
         }

         for(Integer num : counts.keySet()) {
            return num;
         }
         return -1;
      }
   }
}
