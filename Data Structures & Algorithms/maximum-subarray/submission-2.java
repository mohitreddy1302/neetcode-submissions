class Solution {
    public int maxSubArray(int[] nums) {
        // best sum of a subarray ending at the current index
        int currSum = nums[0];
        // best sum seen anywhere so far
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // either extend the previous subarray, or start fresh at nums[i]
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}