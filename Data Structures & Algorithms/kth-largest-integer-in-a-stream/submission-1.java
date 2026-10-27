

class KthLargest {

    // Min-heap that holds only the k largest values seen so far.
    // Its smallest element (the top) is the kth largest overall.
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();   // Java's PriorityQueue is a min-heap by default

        // Add each starting number. Keep only the k largest.
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();            // remove the smallest, it can't be in the top k
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();                // keep the heap at size k
        }
        return pq.peek();             // smallest of the top k = kth largest
    }
}
/*Kth largest: use a min-heap of size k. The top is the smallest of the k largest values, which is the kth largest overall. Anything smaller gets popped.
Kth smallest: use a max-heap of size k. The top is the largest of the k smallest values, which is the kth smallest overall. Anything larger gets popped.*/