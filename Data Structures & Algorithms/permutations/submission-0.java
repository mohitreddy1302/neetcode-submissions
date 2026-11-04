
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Every finished permutation is stored here
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // The permutation we are building right now
        List<Integer> current = new ArrayList<Integer>();

        // used[j] is true when nums[j] is already in current
        boolean[] used = new boolean[nums.length];

        backtrack(nums, current, used, result);
        return result;
    }

    // nums: the input numbers
    // current: the permutation built so far
    // used: which indices of nums are already placed in current
    // result: all finished permutations
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: current has one of every number, so it is a full permutation
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));   // save a copy
            return;
        }

        // Try every number that is not used yet at the next position
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) {
                continue;   // already placed in current, skip it
            }

            // Choose nums[j]
            used[j] = true;
            current.add(nums[j]);

            backtrack(nums, current, used, result);

            // Undo the choice so the next candidate starts from the same state
            current.remove(current.size() - 1);
            used[j] = false;
        }
    }
}