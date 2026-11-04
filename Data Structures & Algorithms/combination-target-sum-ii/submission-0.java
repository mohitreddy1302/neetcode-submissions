

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort first so equal values sit next to each other (needed to skip duplicates)
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combin = new ArrayList<Integer>();
        combSum2(candidates, 0, combin, target, result);
        return result;
    }

    // i: the index we are deciding about
    // combin: the combination built so far
    // tar: the sum still needed
    // result: all valid combinations found
    private void combSum2(int[] candidates, int i, List<Integer> combin, int tar, List<List<Integer>> result) {
        // exact sum reached: save a copy
        if (tar == 0) {
            result.add(new ArrayList<Integer>(combin));
            return;
        }
        // ran out of numbers, or overshot the target
        if (i == candidates.length || tar < 0) {
            return;
        }

        // Take candidates[i] (move to i + 1, since each element is used at most once)
        combin.add(candidates[i]);
        combSum2(candidates, i + 1, combin, tar - candidates[i], result);
        combin.remove(combin.size() - 1);

        // Skip every copy of this value, so the same combination is not built twice
        int next = i + 1;
        while (next < candidates.length && candidates[next] == candidates[i]) {
            next++;
        }
        combSum2(candidates, next, combin, tar, result);
    }
}