package com.github.chen0040.leetcode.day11.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Created by xschen on 6/8/2017.
 *
 * summary:
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * link: https://leetcode.com/problems/queue-reconstruction-by-height/description/
 */
public class ReconstructQueue {
   public class Solution {
      public int[][] reconstructQueue(int[][] people) {
         Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
               if(a[0] == b[0]) return a[1] - b[1];
               return b[0] - a[0];
            }
         });

         List<int[]> temp = new ArrayList<int[]>();
         for(int i=0; i < people.length; ++i) {
            temp.add(people[i][1], new int[] { people[i][0], people[i][1]});
         }

         int[][] result = new int[people.length][];
         int index = 0;
         for(int[] k : temp) {
            result[index] = new int[2];
            result[index][0] = k[0];
            result[index][1] = k[1];
            index++;
         }
         return result;
      }
   }
}
