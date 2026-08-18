
class Solution {
    public int lengthOfLongestSubstring(String s) {
/*
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

        return maxLength;*/
          HashSet<Character> set = new HashSet<>();

        // Left pointer of the window
        int left = 0;

        // Stores the longest valid substring length found
        int maxLength = 0;

        // Right pointer expands the window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If current character already exists,
            // remove characters from the left
            // until the duplicate is gone
            while (set.contains(ch)) {

                // Remove the leftmost character
                set.remove(s.charAt(left));

                // Shrink the window from the left
                left++;
            }

            // Now current character is safe to add
            set.add(ch);

            // Current valid window is from left to right
            int currentLength = right - left + 1;

            // Update the longest length
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}