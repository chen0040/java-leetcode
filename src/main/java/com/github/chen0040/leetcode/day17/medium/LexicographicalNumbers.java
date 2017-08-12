package com.github.chen0040.leetcode.day17.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/lexicographical-numbers/description/
 */
public class LexicographicalNumbers {

   public class Solution {


      public List<Integer> lexicalOrder(int n) {
         List<Integer> res = new ArrayList<Integer>();
         for(int i=1; i < 10; ++i){
            dfs(i, res, n);
         }
         return res;
      }

      private void dfs(int curr, List<Integer> res, int n) {
         if(curr > n) {
            return;
         }

         res.add(curr);
         for(int i=0; i < 10; ++i) {
            if(curr * 10 + i > n) break;
            dfs(curr * 10 +i, res, n);
         }

      }


   }
}
