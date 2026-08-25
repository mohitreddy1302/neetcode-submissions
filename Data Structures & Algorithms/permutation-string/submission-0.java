

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer than s2, impossible
        if (s1.length() > s2.length()) {
            return false;
        }

        int len = s1.length();

        // Sort s1 once
        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);

        // Check every substring of s2 having length s1
        for (int i = 0; i <= s2.length() - len; i++) {

            // Get substring of same length as s1
            String sub = s2.substring(i, i + len);

            // Convert substring to array and sort
            char[] subArray = sub.toCharArray();
            Arrays.sort(subArray);

            // If sorted arrays are equal, it's a permutation
            if (Arrays.equals(s1Array, subArray)) {
                return true;
            }
        }

        return false;
    }
}