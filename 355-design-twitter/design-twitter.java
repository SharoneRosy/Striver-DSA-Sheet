class Twitter {
    private List<int[]> recentTweets;
    private Map<Integer, Set<Integer>> follows;

    public Twitter() {
        recentTweets = new ArrayList<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        recentTweets.add(new int[]{userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> userFollows = follows.getOrDefault(userId, new HashSet<>());

        for (int i = recentTweets.size() - 1; i >= 0; --i) {
            int[] tweet = recentTweets.get(i);
            int postedBy = tweet[0];
            int tweetId = tweet[1];

            if (postedBy == userId || userFollows.contains(postedBy)) {
                feed.add(tweetId);
            }

            if (feed.size() == 10) break;
        }
        
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
    }
