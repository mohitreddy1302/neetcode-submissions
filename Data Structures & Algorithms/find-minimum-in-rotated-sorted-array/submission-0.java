class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Store the smallest value found so far
        int result = nums[0];

        while (left <= right) {

            // If this portion is already sorted,
            // nums[left] is the smallest value in this portion
            if (nums[left] <= nums[right]) {
                result = Math.min(result, nums[left]);
                break;
            }

            int mid = left + (right - left) / 2;

            // Consider nums[mid] as a possible minimum
            result = Math.min(result, nums[mid]);

            /*
             * If nums[mid] >= nums[left],
             * the left portion is sorted.
             * The rotation point is on the right.
             */
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                /*
                 * The middle value is smaller than the left value.
                 * We already saved nums[mid] in result,
                 * so now search the left side.
                 */
                right = mid - 1;
            }
        }

        return result;
    }
}