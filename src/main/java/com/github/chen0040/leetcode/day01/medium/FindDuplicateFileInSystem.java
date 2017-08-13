package com.github.chen0040.leetcode.day01.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.
 *
 * link: https://leetcode.com/problems/find-duplicate-file-in-system/description/
 */
public class FindDuplicateFileInSystem {
   public class Solution {
      public List<List<String>> findDuplicate(String[] paths) {
         Map<String, List<String>> group = new HashMap<String, List<String>>();
         for(int i=0; i < paths.length; ++i) {
            collect(paths[i], group);
         }
         List<List<String>> result = new ArrayList<List<String>>();
         for(List<String> p : group.values()) {
            if(p.size() > 1) {
               result.add(p);
            }
         }
         return result;
      }

      private void collect(String path, Map<String, List<String>> group) {
         String[] parts = path.split(" ");
         String dir = parts[0];
         for(int i=1; i < parts.length; ++i) {
            String file = parts[i];
            int index = file.indexOf("(");
            String filename = file.substring(0, index);
            String text = file.substring(index+1, file.length()-1);

            List<String> paths = null;
            if(group.containsKey(text)) {
               paths = group.get(text);
            } else {
               paths =new ArrayList<String>();
               group.put(text, paths);
            }
            paths.add(dir + "/" + filename);
         }
      }
   }
}
