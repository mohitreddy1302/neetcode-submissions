class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int l = 0;
        int r = 0;

        // keep jumping while the current window does not reach the last index
        while (r < n - 1) {
            int farthest = 0;

            // scan the current window [l, r] and find the furthest reach
            for (int ind = l; ind <= r; ind++) {
                farthest = Math.max(ind + nums[ind], farthest);
            }

            // move to the next window: it starts right after r and ends at farthest
            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}