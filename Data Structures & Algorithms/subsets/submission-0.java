class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // Every subset we finish building gets stored here
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // The subset we are building right now, one number at a time
        List<Integer> current = new ArrayList<Integer>();

        // Start deciding from index 0 (the first number)
        backtrack(nums, 0, current, result);
        return result;
    }

    // Decides whether to include nums[i], then moves on to nums[i + 1]
    // nums: the input numbers
    // i: the index of the number we are deciding about right now
    // current: the subset built so far
    // result: the list of all finished subsets
    private void backtrack(int[] nums, int i, List<Integer> current, List<List<Integer>> result) {

        // Base case: we have decided about every number, so current is one complete subset
        if (i == nums.length) {
            // Store a COPY, because current keeps changing after this point
            result.add(new ArrayList<Integer>(current));
            return;
        }

        // Choice 1: YES, include nums[i]
        current.add(nums[i]);
        backtrack(nums, i + 1, current, result);

        // Undo the choice so current is back to how it was before we added nums[i]
        // current.size() - 1 is the index of the last element, which is nums[i]
        current.remove(current.size() - 1);

        // Choice 2: NO, skip nums[i]
        backtrack(nums, i + 1, current, result);
    }
}