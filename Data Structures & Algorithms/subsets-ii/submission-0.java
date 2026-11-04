
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> current, List<List<Integer>> result) {
        // Base case: every element has been decided, so save the subset
        if (i == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        // Take nums[i]
        current.add(nums[i]);
        backtrack(nums, i + 1, current, result);
        current.remove(current.size() - 1);

        // Skip nums[i], and skip every copy of it at this level
        int next = i + 1;
        while (next < nums.length && nums[next] == nums[i]) {
            next++;
        }
        backtrack(nums, next, current, result);
    }
}