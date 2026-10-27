
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap by squared distance: the farthest of the k closest sits on top
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                b[0] * b[0] + b[1] * b[1],
                a[0] * a[0] + a[1] * a[1]
            )
        );

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();   // remove the farthest point
            }
        }

        // The heap now holds the k closest points
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}