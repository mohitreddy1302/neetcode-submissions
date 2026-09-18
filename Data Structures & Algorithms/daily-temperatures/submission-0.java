class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        // Check each day
        for (int i = 0; i < n; i++) {

            // Check future days after day i
            for (int j = i + 1; j < n; j++) {

                // If a warmer temperature is found
                if (temperatures[j] > temperatures[i]) {

                    // Number of days until the warmer temperature
                    result[i] = j - i;

                    // Stop searching for this day
                    break;
                }
            }
        }

        return result;
    }
}