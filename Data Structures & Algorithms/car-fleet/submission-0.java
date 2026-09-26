

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store car indexes: 0, 1, 2, ...
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        // Sort car indexes by position:
        // closest to target first
        Arrays.sort(order, (a, b) ->
            Integer.compare(position[b], position[a])
        );

        // Store the arrival time of each separate fleet
        Stack<Double> fleetTimes = new Stack<>();

        for (int index : order) {

            // Calculate time for this car to reach the target
            double time =
                (double) (target - position[index]) / speed[index];

            // If this car takes longer, it cannot catch the fleet ahead
            if (fleetTimes.isEmpty() ||
                time > fleetTimes.peek()) {

                // It creates a new fleet
                fleetTimes.push(time);
            }

            // If time <= fleetTimes.peek(),
            // this car catches the fleet ahead,
            // so we do not create a new fleet.
        }

        // The number of fleet arrival times is the number of fleets
        return fleetTimes.size();
    }
}