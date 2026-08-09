class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // key = number
        // value = frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                // Number already exists -> increase count
                map.put(nums[i], map.get(nums[i]) + 1);

            } else {

                // First time seeing number -> count is 1
                map.put(nums[i], 1);
            }
        }

        int[] result = new int[k];

        // Find the highest frequency k times
        for (int i = 0; i < k; i++) {

            int maxFreq = 0;
            int maxNum = 0;

            // Find number with highest frequency
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxNum = entry.getKey();
                }
            }

            // Add it to result
            result[i] = maxNum;

            // Remove it so next iteration finds next highest
            map.remove(maxNum);
        }

        return result;
    }
}