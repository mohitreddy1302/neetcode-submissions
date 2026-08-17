

class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Stores the longest length found so far
        int maxLength = 0;

        // Try every index as the START of a substring
        for (int i = 0; i < s.length(); i++) {

            // New HashSet for each starting position.
            // It stores characters we've seen in the current substring.
            HashSet<Character> set = new HashSet<>();

            // Start from i and keep expanding to the right
            for (int j = i; j < s.length(); j++) {

                // Get current character
                char ch = s.charAt(j);

                // If character is already in the set,
                // we found a duplicate.
                // We cannot continue this substring.
                if (set.contains(ch)) {
                    break;
                }

                // Character is not a duplicate, so store it
                set.add(ch);

                // Current substring goes from index i to j.
                // Therefore its length is j - i + 1.
                int currentLength = j - i + 1;

                // Keep the maximum length we've seen
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}