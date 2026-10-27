
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length - k];
    //nlogn since sort takes that time



        PriorityQueue<Integer> pq = new PriorityQueue<>();   // min-heap
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();   // drop the smallest
        }
        return pq.peek();   // smallest of the k largest
    }
}