package leetcode.recommendlist;

import java.util.*;

public class DesignTwitter355 {
    class Twitter {

        private List<int[]> tweets;
        private Map<Integer, List<Integer>> tweetsByUserId;
        private Map<Integer, Set<Integer>> followers;

        public Twitter() {
            tweets = new ArrayList<>();
            tweetsByUserId = new HashMap<>();
            followers = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweets.add(new int[]{tweetId, userId});
            List<Integer> tweets = tweetsByUserId.getOrDefault(userId, new ArrayList<>());
            tweets.add(tweetId);
            tweetsByUserId.put(userId, tweets);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> newsFeed = new ArrayList<>();

            Set<Integer> followerSet = followers.getOrDefault(userId, new HashSet<>());
            int size = tweets.size();
            for (int i=size-1;i>=0;i--) {
                int[] tweet = tweets.get(i);
                boolean needPosted = followerSet.contains(tweet[1]) || tweet[1] == userId;
                if (needPosted) {
                    newsFeed.add(tweet[0]);
                    if (newsFeed.size() == 10) {
                        return newsFeed;
                    }
                }
            }
            return newsFeed;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> followerSet = followers.getOrDefault(followerId, new HashSet<>());
            followerSet.add(followeeId);
            followers.put(followerId, followerSet);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followerSet = followers.getOrDefault(followerId, new HashSet<>());
            if (followerSet.size() == 0) {
                return;
            }
            followerSet.remove(followeeId);
            followers.put(followerId, followerSet);
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
