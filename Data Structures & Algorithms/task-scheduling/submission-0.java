
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count how many times each task letter appears
        int[] count = new int[26];
        for (char t : tasks) {
            count[t - 'A']++;
        }

        // Max-heap of the counts: the most frequent task is always on top
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) {
            if (c > 0) pq.offer(c);
        }

        int time = 0;
        int cycle = n + 1;   // one round = n+1 slots (a task plus its cooldown)

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();   // tasks we ran this round, with counts reduced
            int taken = 0;

            // Run up to n+1 different tasks, taking the most frequent first
            while (taken < cycle && !pq.isEmpty()) {
                int remaining = pq.poll() - 1;   // run one copy of this task
                if (remaining > 0) temp.add(remaining);
                taken++;
            }

            // Put the unfinished tasks back so they can run in the next round
            for (int r : temp) {
                pq.offer(r);
            }

            // If more work is waiting (or we still have a cooldown to finish), count the full cycle.
            // Otherwise we only count the slots we actually used.
            time += (pq.isEmpty() && temp.isEmpty()) ? taken : cycle;
        }

        return time;
    }
}