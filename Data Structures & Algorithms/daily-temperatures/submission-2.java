class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
/*
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
        */


        int n = temperatures.length;
        int[] result = new int[n];

        // Store indexes of days waiting for a warmer temperature
        Stack<Integer> stack = new Stack<>();

        for (int current = 0; current < n; current++) {

            // Resolve previous days when today's temperature is warmer
            while (!stack.isEmpty() &&
                   temperatures[current] > temperatures[stack.peek()]) {

                int previousDay = stack.pop();

                // Number of days between the two days
                result[previousDay] = current - previousDay;
            }

            // Current day waits for a warmer future temperature
            stack.push(current);
        }

        return result;
    }
}
    