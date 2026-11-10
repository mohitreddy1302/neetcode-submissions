class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Step 1: check if the trip is possible at all.
        // The total fuel available must be at least the total fuel needed.
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;   // not enough fuel around the whole circle
        }

        // Step 2: a valid start exists, so find it with one pass.
        int tank = 0;    // fuel left since the current candidate start
        int start = 0;   // current candidate starting station

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];

            // The tank ran dry going from start to i+1,
            // so no station from start through i can be the answer.
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}