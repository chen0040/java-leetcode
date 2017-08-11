package com.github.chen0040.leetcode.day16.medium;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/rectangle-area/description/
 */
public class RectangleArea {
   static class Rect {
      int left;
      int right;
      int bottom;
      int top;

      public Rect(int left, int bottom, int right, int top) {
         this.left = left;
         this.bottom = bottom;
         this.right = right;
         this.top = top;
      }

      public Rect intersect(Rect that) {
         Rect rect = new Rect(0, 0, 0, 0);
         if(this.right <= that.left || that.top <= this.bottom || this.top <= that.bottom || that.right <= this.left) return rect;
         rect.right = Math.min(this.right, that.right);
         rect.left = Math.max(this.left, that.left);
         rect.bottom = Math.max(this.bottom, that.bottom);
         rect.top = Math.min(this.top, that.top);
         return rect;
      }

      public int area() {
         int width = this.right - this.left;
         int height = this.top - this.bottom;
         return width * height;
      }
   }

   public class Solution {


      public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
         Rect rect1 = new Rect(A, B, C, D);
         Rect rect2 = new Rect(E, F, G, H);

         if(rect1.area()==0) return rect2.area();
         else if(rect2.area()==0) return rect1.area();

         Rect rect = rect1.intersect(rect2);

         return (rect1.area() + rect2.area()) - rect.area();

      }
   }
}
