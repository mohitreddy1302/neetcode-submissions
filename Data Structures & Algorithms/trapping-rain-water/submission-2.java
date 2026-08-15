class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        // Maximum height seen so far from left and right
        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left < right) {

            // Update maximum heights seen so far
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // Left boundary is smaller
            if (leftMax < rightMax) {

                // Water above current left bar
                totalWater += leftMax - height[left];

                // Move left pointer
                left++;

            } else {

                // Water above current right bar
                totalWater += rightMax - height[right];

                // Move right pointer
                right--;
            }
        }

        return totalWater;
    }
}