class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();
        findSubsets(nums, 0, ans, result);
        return result;
    }

    private void findSubsets(int[] nums, int i, List<Integer> ans, List<List<Integer>> result) {
        // base case: every number has been decided, so save a copy of ans
        if (i == nums.length) {
            result.add(new ArrayList<Integer>(ans));
            return;
        }

        // Yes choice: include nums[i]
        ans.add(nums[i]);
        findSubsets(nums, i + 1, ans, result);
        ans.remove(ans.size() - 1);   // undo so the No choice starts clean

        // No choice: skip nums[i]
        findSubsets(nums, i + 1, ans, result);
    }
}