/*class Solution {
    public int longestConsecutive(int[] nums) {

        int longest = 0;

        // Try every number as a possible start
        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];
            int length = 1;

            // Keep looking for current + 1
            while (contains(nums, current + 1)) {
                current++;
                length++;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }

    // Linear search to check whether target exists
    private boolean contains(int[] nums, int target) {

        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }
}*/

class Solution {
    public int longestConsecutive(int[] nums) {

        // Store all unique numbers
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Check every unique number
        for (int num : set) {

            // If num - 1 doesn't exist,
            // this number is the START of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Keep finding the next consecutive number
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                // Store the longest sequence found
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}