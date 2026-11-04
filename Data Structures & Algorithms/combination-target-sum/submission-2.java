class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combin = new ArrayList<Integer>();
        combSum(nums, 0, combin, target, result);
        return result;
    }

    private void combSum(int[] nums, int i, List<Integer> combin, int tar, List<List<Integer>> result) {
        // exact sum: save a copy
        if (tar == 0) {
            result.add(new ArrayList<Integer>(combin));
            return;
        }
        // ran out of numbers, or overshot the target
        if (i == nums.length || tar < 0) {
            return;
        }

        // Take nums[i] (stay at i, so it can be reused)
        combin.add(nums[i]);
        combSum(nums, i, combin, tar - nums[i], result);
        combin.remove(combin.size() - 1);

        // Skip nums[i] (move to i + 1)
        combSum(nums, i + 1, combin, tar, result);
    }
}