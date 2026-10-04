class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // Target is on the right side
                left = mid + 1;
            } else {
                // Target is on the left side
                right = mid - 1;
            }
        }

        // Target was not found
        return -1;
    }
}