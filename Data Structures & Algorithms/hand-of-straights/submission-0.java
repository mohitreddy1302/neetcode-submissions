
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // The cards must split into equal groups
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Count how many copies of each card value we have
        TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        // Repeatedly take the smallest remaining card as the start of a group
        while (!count.isEmpty()) {
            int start = count.firstKey();

            // Build one group: start, start+1, ..., start+groupSize-1
            for (int v = start; v < start + groupSize; v++) {
                int c = count.getOrDefault(v, 0);

                // A needed card is missing, so no valid grouping exists
                if (c == 0) {
                    return false;
                }

                // Use one copy of v; remove the key once none are left
                if (c == 1) {
                    count.remove(v);
                } else {
                    count.put(v, c - 1);
                }
            }
        }

        return true;
    }
}