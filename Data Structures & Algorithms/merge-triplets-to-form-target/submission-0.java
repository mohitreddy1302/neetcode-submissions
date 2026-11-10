class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // Which target values we have matched so far (x, y, z)
        boolean x = false, y = false, z = false;

        for (int[] t : triplets) {
            // A triplet can be used only if none of its values exceed the target.
            // Using it would push a coordinate above the target, and max never lowers it.
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                // Record each coordinate that exactly matches the target
                if (t[0] == target[0]) x = true;
                if (t[1] == target[1]) y = true;
                if (t[2] == target[2]) z = true;
            }
        }
        
        // All three coordinates must be matched by some usable triplet
        return x && y && z;
    }
}