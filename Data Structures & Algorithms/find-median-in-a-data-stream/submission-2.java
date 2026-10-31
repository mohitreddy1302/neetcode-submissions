class MedianFinder {

// Max-heap for the smaller half (top = largest of the small half)
private PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    // Min-heap for the larger half (top = smallest of the large half)
    private PriorityQueue<Integer> large = new PriorityQueue<>();

    public MedianFinder() {
    }
    
     public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}