package com.github.chen0040.leetcode.day10.easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 *
 * link: https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 */
public class MinimumIndexSum {
   public class Solution {
      public String[] findRestaurant(String[] list1, String[] list2) {
         Map<String, Integer> map1 = new HashMap<String, Integer>();
         for(int i=0; i < list1.length; ++i) {
            map1.put(list1[i], i);
         }

         int minIndexSum = list1.length + list2.length;
         List<String> common = new ArrayList<String>();
         for(int i=0; i < list2.length; ++i) {
            String res = list2[i];
            if(map1.containsKey(res)) {
               int indexSum = i + map1.get(res);
               if(indexSum < minIndexSum) {
                  common.clear();
                  common.add(res);
                  minIndexSum = indexSum;
               } else if(indexSum == minIndexSum){
                  common.add(res);
               }
            }
         }

         String[] result = new String[common.size()];
         for(int i=0; i < common.size(); ++i) {
            result[i] = common.get(i);
         }
         return result;
      }
   }
}
