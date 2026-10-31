

class Twitter {

    private static int time = 0;

    // Each heap entry remembers which user it came from, and where it sits in that user's list
    private static class Entry {
        int tweetId, time, userId, index;
        Entry(int tweetId, int time, int userId, int index) {
            this.tweetId = tweetId;
            this.time = time;
            this.userId = userId;
            this.index = index;
        }
    }

    private Map<Integer, List<int[]>> tweets = new HashMap<>();   // userId -> list of {tweetId, time}
    private Map<Integer, Set<Integer>> follows = new HashMap<>();

    public Twitter() {} 

    public void postTweet(int userId, int tweetId) {

    // If the user does not have a tweet list, create one.
    if (!tweets.containsKey(userId)) {
        tweets.put(userId, new ArrayList<>());
    }

    // Add the tweet ID and its posting time.
    tweets.get(userId).add(new int[]{tweetId, time++});
}

    public List<Integer> getNewsFeed(int userId) {
        // Max-heap by timestamp: newest tweet on top
 PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        // Seed with the most recent tweet of the user and each followee
      Set<Integer> users;

if (follows.containsKey(userId)) {
    // Copy the users followed by userId.
    users = new HashSet<>(follows.get(userId));
} else {
    // This user follows nobody.
    users = new HashSet<>();
}
// Include the user's own tweets.
users.add(userId);

        for (int u : users) {
            List<int[]> list = tweets.get(u);
            if (list != null && !list.isEmpty()) {
                int last = list.size() - 1;
                int[] t = list.get(last);
                pq.offer(new Entry(t[0], t[1], u, last));
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty() && feed.size() < 10) {
            Entry e = pq.poll();
            feed.add(e.tweetId);

            // Push the previous tweet from the same user, if any
            if (e.index > 0) {
            int[] prev = tweets.get(e.userId).get(e.index - 1);
                pq.offer(new Entry(prev[0], prev[1], e.userId, e.index - 1));
            }
        }
        return feed;
    }

 public void follow(int followerId, int followeeId) {

    // A user cannot follow themself.
    if (followerId == followeeId) {
        return;
    }

    // If the follower does not have a set yet,
    // create an empty set for that user.
    if (!follows.containsKey(followerId)) {
        follows.put(followerId, new HashSet<>());
    }

    // Add the user being followed.
    follows.get(followerId).add(followeeId);
}

public void unfollow(int followerId, int followeeId) {

    // Get the set of users followed by followerId.
    Set<Integer> set = follows.get(followerId);

    // If the set exists, remove followeeId from it.
    if (set != null) {
        set.remove(followeeId);
    }
}
}