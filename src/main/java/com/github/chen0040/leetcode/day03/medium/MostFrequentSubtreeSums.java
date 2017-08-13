package com.github.chen0040.leetcode.day03.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * link: https://leetcode.com/problems/most-frequent-subtree-sum/description/
 */
public class MostFrequentSubtreeSums {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {

      private void quickSort(int[] a, Map<Integer, Integer> sums) {
         quickSort(a, 0, a.length-1, sums);
      }

      private void quickSort(int[] a, int lo, int hi, Map<Integer, Integer> sums) {
         if(lo >= hi) return;
         int j = partition(a, lo, hi, sums);
         quickSort(a, lo, j-1, sums);
         quickSort(a, j+1, hi, sums);
      }

      private int partition(int[] a, int lo, int hi, Map<Integer, Integer> sums){
         int i = lo, j = hi+1;
         int v = sums.get(a[lo]);
         while(true) {
            while(v < sums.get(a[++i])) {
               if(i >= hi) break;
            }
            while(v > sums.get(a[--j])) {
               if(j <= lo) break;
            }
            if(i >= j){
               break;
            }
            exchange(a, i, j);
         }
         exchange(a, lo, j);
         return j;
      }

      private void exchange(int[] a, int i, int j){
         int temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }

      public int[] findFrequentTreeSum(TreeNode root) {
         if(root == null) return new int[0];
         Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
         collect(root, sums);
         int[] orders = new int[sums.size()];
         int index = 0;
         for(Integer val : sums.keySet()) {
            orders[index++] = val;
         }
         quickSort(orders, sums);
         if(orders[0] == 0) {
            List<Integer> queue = new ArrayList<Integer>();
            collect(root, queue);
            int[] result = new int[queue.size()];
            for(int i=0; i < result.length; ++i) {
               result[i] = queue.get(i);
            }
            return result;
         } else {
            List<Integer> queue = new ArrayList<Integer>();
            int max = sums.get(orders[0]);
            for(int i=0; i < orders.length; ++i) {
               if(sums.get(orders[i]) == max) {
                  queue.add(orders[i]);
               }
            }
            int[] result = new int[queue.size()];
            for(int i=0; i < result.length; ++i) {
               result[i] = queue.get(i);
            }
            return result;
         }
      }

      private void collect(TreeNode x, List<Integer> queue) {
         if(x == null) {
            return;
         }
         collect(x.left, queue);
         queue.add(x.val);
         collect(x.right, queue);
      }

      private int collect(TreeNode x, Map<Integer, Integer> sums) {
         if(x == null) {
            return 0;
         }
         if(isLeave(x)) {
            sums.put(x.val, sums.getOrDefault(x.val, 0) + 1);
            return x.val;
         }

         int sumLeft = collect(x.left, sums);
         int sumRight = collect(x.right, sums);
         int sum = sumLeft + x.val + sumRight;
         sums.put(sum, sums.getOrDefault(sum, 0) + 1);
         return sum;

      }

      private boolean isLeave(TreeNode x) {
         return x.left == null && x.right == null;
      }
   }
}
