class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the middle element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }

            /*
             * Check whether the left half is sorted.
             *
             * If nums[left] <= nums[mid], then the values from
             * left to mid are in ascending order.
             */
            if (nums[left] <= nums[mid]) {

                /*
                 * Check whether the target lies inside the sorted
                 * left half.
                 */
                if (nums[left] <= target && target < nums[mid]) {
                    // Search the left half
                    right = mid - 1;
                } else {
                    // Target is not in the left half,
                    // so search the right half
                    left = mid + 1;
                }

            } else {
                /*
                 * If the left half is not sorted, the right half
                 * must be sorted.
                 */
                if (nums[mid] < target && target <= nums[right]) {
                    // Search the right half
                    left = mid + 1;
                } else {
                    // Target is not in the right half,
                    // so search the left half
                    right = mid - 1;
                }
            }
        }

        // Target was not found
        return -1;
    }
}