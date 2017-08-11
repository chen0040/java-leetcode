package com.github.chen0040.leetcode.day16.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/valid-square/description/
 */
public class ValidSquare {
   public class Solution {
      public int distance(int[] pt1, int[] pt2) {
         int dx = pt1[0] - pt2[0];
         int dy = pt1[1] - pt2[1];
         return (int)Math.sqrt(dx * dx + dy * dy);
      }

      public int[] minus(int[] pt1, int[] pt2) {
         int[] v = new int[2];
         v[0] = pt2[0] - pt1[0];
         v[1] = pt2[1] - pt1[1];

         return v;
      }

      public int dotProduct(int[] pt1, int[] pt2) {
         return pt1[0] * pt2[0] + pt1[1] * pt2[1];
      }

      public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
         int[] set = new int[] { 0, 1,2, 3 };

         int[][] points = new int[4][];
         points[0] = p1;
         points[1] = p2;
         points[2] = p3;
         points[3] = p4;
         List<int[]> permutations = permute(set, 0, new ArrayList<int[]>());

         for(int[] seq : permutations) {
            p1 = points[seq[0]];
            p2 = points[seq[1]];
            p3 = points[seq[2]];
            p4 = points[seq[3]];

            int len1 = distance(p1, p2);
            int len2 = distance(p2, p3);
            int len3 = distance(p3, p4);
            int len4 = distance(p4, p1);

            if(len1 * len2 *len3 *len4 == 0) return false;
            if(len1 != len2 || len1 != len3 || len1 != len4) continue;


            int[] v1 = minus(p1, p2);
            int[] v2 = minus(p2, p3);
            int[] v3 = minus(p3, p4);
            int[] v4 = minus(p4, p1);

            if(dotProduct(v1, v2) == 0 && dotProduct(v2, v3) == 0 && dotProduct(v3, v4) == 0){
               return true;
            }
         }
         return false;
      }

      private List<int[]> permute(int[] set, int d, List<int[]> perms) {
         if(perms.isEmpty()) {
            perms.add(new int[4]);
         }

         if(d == set.length) {
            return perms;
         }

         int val = set[d];
         List<int[]> result = new ArrayList<int[]>();
         for(int[] perm : perms) {
            List<int[]> newPerms = generate(perm, val, d);
            result.addAll(newPerms);
         }
         return permute(set, d+1, result);
      }

      private List<int[]> generate(int[] perm, int val, int n) {
         List<int[]> result = new ArrayList<int[]>();
         for(int i=0; i < n; ++i) {
            result.add(insert(perm, i, val, n));
         }
         result.add(insert(perm, n, val, n));
         return result;
      }

      private int[] insert(int[] perm, int insert_index, int val, int n) {
         int[] result = new int[perm.length];
         int index = 0;
         for(int i=0; i < n; ++i) {
            if(i == insert_index) {
               result[index++] = val;
            }
            result[index++] = perm[i];
         }
         if(insert_index == n) {
            result[index++] = val;
         }
         return result;
      }
   }
}
