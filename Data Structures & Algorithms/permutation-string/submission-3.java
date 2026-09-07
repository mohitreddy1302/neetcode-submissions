

class Solution {
    public boolean checkInclusion(String s1, String s2) {

     /*   // If s1 is longer than s2, impossible
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

        return false; */

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int windowSize = s1.length();

        // Slide through s2
        for (int i = 0; i < s2.length(); i++) {

            // Add the current character to the window
            windowCount[s2.charAt(i) - 'a']++;

            // Remove the character that is outside the window
            if (i >= windowSize) {
                windowCount[s2.charAt(i - windowSize) - 'a']--;
            }

            // Compare the current window with s1
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
 
    }
}
/*The code does this:

Count the letters in s1.
Move through s2 one character at a time.
Add the new character to the current window’s count.
Remove the old character when it leaves the window.
Compare the window’s letter counts with s1’s letter counts.
If they match, return true.
If no window matches, return false.*/