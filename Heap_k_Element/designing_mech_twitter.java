package Heap_k_Element;

import java.util.*;


public class designing_mech_twitter {
     class Tweet implements Comparable<Tweet>{
        int time;
        int tweetId;
        Tweet(int t,int id){
            time=t;
            tweetId=id;
        }
        public int compareTo(Tweet that){
            return that.time-this.time;
        }
    }
    class User{
        int userId;
        HashSet<Integer>followers;
        List<Tweet>tweets;

        User(int userId){
            this.userId=userId;
            followers=new HashSet<>();
            tweets=new LinkedList<>();
        }

        public void addTweet(Tweet t){
            tweets.add(0,t); //insertion at the head
        }


        public void addFollower(int followeeId){
            followers.add(followeeId);
        }


        public void removeFollower(int followeeId){
            followers.remove(followeeId);
        }

    }

    class Twitter {
        HashMap<Integer,User>usermap;
        int timeCounter=0;

        public Twitter() {
            usermap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            timeCounter++;
            if(!usermap.containsKey(userId)){
                usermap.put(userId,new User(userId));
            }
            User user=usermap.get(userId);
            user.addTweet(new Tweet(timeCounter, tweetId));

        }

        public List<Integer> getNewsFeed(int userId) {
            if(!usermap.containsKey(userId)){
                return new ArrayList<>();
            }
            int count=0;
            PriorityQueue<Tweet> pq=new PriorityQueue<>();
            //add self+ followers recent tweets
            User user = usermap.get(userId);
            for(int followerId : user.followers){
                for(Tweet tweet : usermap.get(followerId).tweets){
                    pq.offer(tweet);
                    count++;
                    if(count>10){
                        break;
                    }
                }

            }
            count=0;
            for(Tweet tweet : user.tweets){
                pq.offer(tweet);
                count++;
                if(count>10){
                    break;
                }
            }
            List<Integer> res= new ArrayList<>();
            int index=0;
            while(!pq.isEmpty() && index<10){
                Tweet tweet=pq.poll();
                res.add(tweet.tweetId);
                index++;
            }
            return res;

        }


        public void follow(int followerId, int followeeId) {
            if(!usermap.containsKey(followerId)){
                usermap.put(followerId,new User(followerId));
            }
            if(!usermap.containsKey(followeeId)){
                usermap.put(followeeId,new User(followeeId));
            }
            User user=usermap.get(followerId);
            user.addFollower(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if(!usermap.containsKey(followerId) || !usermap.containsKey(followeeId)){
                return;
            }
            User user=usermap.get(followerId);
            user.removeFollower(followeeId);

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
