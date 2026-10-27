
class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max-heap: the heaviest stone is always at the top
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        // Keep smashing while at least two stones remain
        while (pq.size() > 1) {
            int y = pq.poll();   // heaviest stone
            int x = pq.poll();   // second heaviest stone

            // If they're different, the lighter one is destroyed and the
            // heavier one is reduced to y - x. If equal, both are gone.
            if (y != x) {
                pq.offer(y - x);
            }
        }

        // One stone left: return its weight. None left: return 0.
        return pq.isEmpty() ? 0 : pq.peek();
    }
}