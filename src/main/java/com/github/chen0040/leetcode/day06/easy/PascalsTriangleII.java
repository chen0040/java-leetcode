package com.github.chen0040.leetcode.day06.easy;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * link: https://leetcode.com/problems/pascals-triangle-ii/description/
 */
public class PascalsTriangleII {
   public class Solution {
      public List<Integer> getRow(int rowIndex) {
         List<Integer> curr = new ArrayList<Integer>();
         if(rowIndex < 0) return curr;
         curr.add(1);
         if(rowIndex == 0) return curr;
         return getRow(curr, rowIndex, 0);
      }

      public List<Integer> getRow(List<Integer> prev, int rowIndex, int d) {
         if(d == rowIndex){
            return prev;
         }
         List<Integer> curr = new ArrayList<Integer>();
         int size = prev.size()+1;
         List<Integer> current = new ArrayList<Integer>();
         for(int i=0; i < size; ++i) {
            int j = i - 1;
            if(j < 0) {
               current.add(prev.get(i));
            } else if(i == size-1) {
               current.add(prev.get(j));
            } else {
               current.add(prev.get(j) + prev.get(i));
            }
         }
         return getRow(current, rowIndex, d + 1);
      }
   }
}
