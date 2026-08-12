class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Start one pointer at each end
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            // Found the target
            if (sum == target) {
                // +1 because the problem wants 1-indexed positions
                return new int[]{left + 1, right + 1};
            }

            // Sum is too small -> need a bigger number
            if (sum < target) {
                left++;
            }

            // Sum is too big -> need a smaller number
            else {
                right--;
            }
        }

        // Problem guarantees a solution, so normally we won't reach here
        return new int[]{};
    }
}