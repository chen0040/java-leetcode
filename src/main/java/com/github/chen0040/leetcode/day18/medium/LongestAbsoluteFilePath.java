package com.github.chen0040.leetcode.day18.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/longest-absolute-file-path/description/
 */
public class LongestAbsoluteFilePath {

   static class Dir {
      String name;
      List<Dir> dirs = new ArrayList<Dir>();


      public Dir(String name) {
         this.name = name;
      }


      public void append(String dirName, int depth) {
         if (depth == 1) {
            dirs.add(new Dir(dirName));
         }
         else {
            dirs.get(dirs.size() - 1).append(dirName, depth - 1);
         }
      }


      public int maxLength() {
         if (dirs.isEmpty()) {
            if (name.contains(".")) {
               return name.length();
            }
            else {
               return 0;
            }
         }

         int maxLen = 0;
         for (Dir dir : dirs) {
            int dirLen = dir.maxLength();
            if (dirLen > 0) {
               maxLen = Math.max(dirLen, maxLen);
            }
         }

         if (maxLen == 0)
            return 0;

         return name.length() + 1 + maxLen;
      }
   }

   public class Solution {

      public int lengthLongestPath(String input) {
         String[] parts = input.split("\n");

         List<Dir> rootDirs = new ArrayList<Dir>();
         for(int i=0; i < parts.length; ++i) {
            String part = parts[i];
            if(!part.startsWith("\t")) {
               Dir rootDir = new Dir(part);
               rootDirs.add(rootDir);
            } else {
               int depth = 0;
               while(part.startsWith("\t")) {
                  part = part.substring(1);
                  depth++;
               }
               rootDirs.get(rootDirs.size()-1).append(part, depth);
            }
         }

         //print(rootDirs);
         int maxLength = 0;
         for(Dir rootDir : rootDirs){
            maxLength = Math.max(maxLength, rootDir.maxLength());
         }

         return maxLength;
      }

      private void print(List<Dir> dirs) {
         for(Dir dir : dirs) print(dir, "");
      }

      private void print(Dir dir, String prefix){
         System.out.println(prefix + dir.name);
         for(Dir subDir : dir.dirs) {
            print(subDir, prefix + "\t");
         }
      }

      private void print(String[] list) {
         for(String line: list)
            System.out.println(line);
      }



   }
}
