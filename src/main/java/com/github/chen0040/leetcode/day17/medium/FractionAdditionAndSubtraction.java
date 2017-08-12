package com.github.chen0040.leetcode.day17.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/fraction-addition-and-subtraction/description/
 */
public class FractionAdditionAndSubtraction {
   static class Fraction {
      int numerator;
      int denominator;
      int sign = 1;
      public String toString() {
         return (sign * numerator) + "/" + denominator;
      }

      private int gcd(int a, int b) {
         while(a != 0 && b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
         }
         return a + b;
      }

      public Fraction add(Fraction that) {
         int denom1 = this.denominator;
         int denom2 = that.denominator;
         int gcd = gcd(denom1, denom2);

         int temp1 = denom1 / gcd;
         int temp2 = denom2 / gcd;

         Fraction f = new Fraction();
         f.denominator = denom1 * temp2;
         f.numerator = this.sign * this.numerator * temp2 + that.sign * that.numerator * temp1;
         if(f.numerator < 0) {
            f.numerator *= (-1);
            f.sign = -1;
         }

         gcd = gcd(f.numerator, f.denominator);
         f.numerator /= gcd;
         f.denominator /= gcd;
         return f;
      }
   }

   public class Solution {



      public String fractionAddition(String expression) {
         StringBuilder sb_num = new StringBuilder();
         StringBuilder sb_denom = new StringBuilder();

         List<Fraction> fractions = new ArrayList<Fraction>();

         Fraction f = new Fraction();

         String temp;
         boolean on_num = true;
         for(int i=0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if(c == '/') {
               int numerator = Integer.parseInt(sb_num.toString());
               f.numerator = numerator;
               sb_num = new StringBuilder();
               on_num = false;
            } else if(c == '-' || c == '+') {
               temp = sb_denom.toString();
               sb_denom = new StringBuilder();
               if(temp.length() != 0) {
                  f.denominator = Integer.parseInt(temp);
                  fractions.add(f);
                  f = new Fraction();
               }
               if(c == '-') {
                  f.sign = -1;
               }
               on_num = true;
            } else {
               if(on_num) sb_num.append(c);
               else sb_denom.append(c);
            }
         }

         temp = sb_denom.toString();
         if(temp.length() != 0) {
            f.denominator = Integer.parseInt(temp);
            fractions.add(f);
         }

         Fraction result = null;
         for(Fraction fraction : fractions) {
            if(result == null) {
               result = fraction;
            } else {
               result = result.add(fraction);
            }

         }

         return result.toString();
      }
   }
}
