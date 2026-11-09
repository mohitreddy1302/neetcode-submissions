class Solution {
    public boolean canJump(int[] nums) {
          // Farthest index we can reach so far
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            // If we can't reach index i, we're stuck before it
            if (i > farthest) {
                return false;
            }

            // From index i we can reach up to i + nums[i]
            farthest = Math.max(farthest, i + nums[i]);

            // Reached or passed the last index
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
/*Reachability: you can only stand on index i if some earlier index’s jump landed at or past it. So if i is beyond farthest, you’re stuck, and the answer is false.
Success: if farthest reaches the last index at any point, you can get there, so the answer is true.*/

      
