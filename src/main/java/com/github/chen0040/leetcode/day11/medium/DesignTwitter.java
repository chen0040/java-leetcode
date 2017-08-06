package com.github.chen0040.leetcode.day11.medium;


import java.util.*;


/**
 * Created by xschen on 6/8/2017.
 *
 * summary:
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 * link: https://leetcode.com/problems/design-twitter/description/
 */
public class DesignTwitter {
   private static int timer = 0;
   public class Twitter {

      private Map<Integer, Set<Integer>> followers = new HashMap<Integer, Set<Integer>>();
      private Map<Integer, Set<Integer>> followees = new HashMap<Integer, Set<Integer>>();

      private Map<Integer, List<int[]>> feeds = new HashMap<Integer, List<int[]>>();



      /** Initialize your data structure here. */
      public Twitter() {

      }

      /** Compose a new tweet. */
      public void postTweet(int userId, int tweetId) {

         if(feeds.containsKey(userId)) {
            feeds.get(userId).add(new int[] { tweetId, userId, timer });
         } else {
            List<int[]> news = new ArrayList<int[]>();
            news.add(new int[] { tweetId, userId, timer });
            feeds.put(userId, news);
         }


         timer++;
      }

      /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
      public List<Integer> getNewsFeed(int userId) {
         List<int[]> news = getFeeds(userId);
         List<Integer> last10 =new ArrayList<Integer>();
         for(int i=0; i < news.size(); ++i) {
            if(last10.size() >= 10) break;
            int[] fn = news.get(i);
            last10.add(fn[0]);
         }
         return last10;
      }

      private List<int[]> getFeeds(int userId) {
         List<int[]> userFeed = feeds.getOrDefault(userId, new ArrayList<int[]>());
         Set<Integer> fset = followees.getOrDefault(userId, new HashSet<Integer>());

         PriorityQueue<int[]> feedQ = new PriorityQueue<>((t1, t2) -> t2[2] - t1[2]);
         feedQ.addAll(userFeed);

         for(Integer fid : fset) {
            List<int[]> ffeeds = feeds.getOrDefault(fid, new ArrayList<int[]>());
            feedQ.addAll(ffeeds);
         }

         List<int[]> result =new ArrayList<int[]>();
         while(!feedQ.isEmpty()) {
            if(result.size() >= 10) break;
            result.add(feedQ.remove());
         }

         return result;

      }

      /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
      public void follow(int followerId, int followeeId) {
         if(followerId == followeeId) return;
         Set<Integer> set = null;
         if(followers.containsKey(followeeId)) {
            set = followers.get(followeeId);
         } else {
            set = new HashSet<Integer>();
            followers.put(followeeId, set);
         }

         set.add(followerId);

         if(followees.containsKey(followerId)) {
            set = followees.get(followerId);
         } else {
            set = new HashSet<Integer>();
            followees.put(followerId, set);
         }
         set.add(followeeId);
      }

      /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
      public void unfollow(int followerId, int followeeId) {
         if(followers.containsKey(followeeId)) {
            Set<Integer> set = followers.get(followeeId);
            set.remove(followerId);
         }
         if(followees.containsKey(followerId)) {
            Set<Integer> set = followees.get(followerId);
            set.remove(followeeId);
         }
      }
   }
}
