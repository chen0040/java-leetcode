package com.github.chen0040.leetcode.day01.medium;


/**
 * Created by xschen on 27/7/2017.
 *
 * summary:
 * Given two strings representing two complex numbers.
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 *
 * link: https://leetcode.com/problems/complex-number-multiplication/tabs/description
 */
public class ComplexNumberMultiplication {
   public class Solution {
      public String complexNumberMultiply(String a, String b) {
         String[] parts_a = a.split("\\+");
         String[] parts_b = b.split("\\+");
         int real_a = Integer.parseInt(parts_a[0]);
         int real_b = Integer.parseInt(parts_b[0]);
         int img_a = Integer.parseInt(parts_a[1].substring(0, parts_a[1].length() - 1));
         int img_b = Integer.parseInt(parts_b[1].substring(0, parts_b[1].length() - 1));

         int real = real_a * real_b - img_a * img_b;
         int img = real_a * img_b + img_a * real_b;
         return real + "+" + img + "i";
      }
   }
}
