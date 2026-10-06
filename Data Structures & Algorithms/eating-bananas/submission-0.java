class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // The minimum possible eating speed is 1 banana per hour
        int start = 1;

        // The maximum possible useful speed is the largest pile
        int end = 0;

        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        // Stores the minimum valid eating speed found so far
        int answer = end;

        // Binary search for the minimum eating speed
        while (start <= end) {

            // Calculate the middle eating speed
            int speed = start + (end - start) / 2;

            // Calculate how many hours are needed at this speed
            long hoursNeeded = 0;

            for (int pile : piles) {

                /*
                 * Calculate the hours needed for this pile.

                 * This is ceiling division:
                 * ceil(pile / speed)

                 * Example:
                 * pile = 7, speed = 3
                 * hours = ceil(7 / 3) = 3
                 */
                hoursNeeded += (pile + speed - 1) / speed;

                /*
                 * If the required hours already exceed h,
                 * there is no need to check the remaining piles.
                 */
                if (hoursNeeded > h) {
                    break;
                }
            }

            /*
             * If Koko can finish within h hours,
             * this speed is possible.

             * We try a smaller speed to find the minimum.
             */
            if (hoursNeeded <= h) {
                answer = speed;
                end = speed - 1;
            }

            /*
             * If Koko cannot finish within h hours,
             * she needs to eat faster.
             */
            else {
                start = speed + 1;
            }
        }

        // Return the minimum eating speed that works
        return answer;
    }
}