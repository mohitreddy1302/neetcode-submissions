class Solution {
    public int findDuplicate(int[] nums) {

        /*
         * Treat the array like a linked list:
         *
         * The current value tells us the next position.
         * For example:
         * nums[0] = 1 means 0 points to 1.
         */
        int slow = nums[0];
        int fast = nums[0];

        /*
         * Move slow one step and fast two steps initially.
         */
        slow = nums[slow];
        fast = nums[nums[fast]];

        /*
         * Phase 1: Detect the cycle.
         *
         * slow moves one step.
         * fast moves two steps.
         *
         * Since the duplicate creates a cycle,
         * slow and fast will eventually meet.
         */
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        /*
         * Phase 2: Find the beginning of the cycle.
         *
         * Move slow back to the starting point.
         */
        slow = nums[0];

        /*
         * Now move both pointers one step at a time.
         * They will meet at the duplicate number.
         */
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // Both pointers point to the duplicate number.
        return slow;
    }
}