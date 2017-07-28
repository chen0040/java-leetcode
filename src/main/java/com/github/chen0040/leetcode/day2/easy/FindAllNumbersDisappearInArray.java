package com.github.chen0040.leetcode.day2.easy;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/tabs/description
 */
public class FindAllNumbersDisappearInArray {
  public class Solution {
     public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] marked = new boolean[nums.length];
        for(int i=0; i < nums.length; ++i) {
           int val = nums[i];
           marked[val-1] = true;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i < nums.length; ++i) {
           if(!marked[i]) {
              result.add(i+1);
           }
        }
        return result;
     }
  }
}
