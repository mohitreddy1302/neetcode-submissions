/*class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int numberOfWindows = nums.length - k + 1;
        int[] result = new int[numberOfWindows];

        int resultIndex = 0;

        // Choose the starting position of each window
        for (int left = 0; left <= nums.length - k; left++) {

            int maximum = nums[left];

            // Check all k elements inside the current window
            for (int right = left; right < left + k; right++) {
                maximum = Math.max(maximum, nums[right]);
            }

            result[resultIndex] = maximum;
            resultIndex++;
        }

        return result;
    }
}*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        for (int right = 0; right < nums.length; right++) {

            // Remove indexes that are outside the window
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // Remove smaller values from the back
            // because they can never become the maximum
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // Add the current index
            deque.offerLast(right);

            // A complete window is formed
            if (right >= k - 1) {
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }

        return result;
    }
}