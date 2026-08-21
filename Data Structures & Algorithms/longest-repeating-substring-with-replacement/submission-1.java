/*class Solution {
    public int characterReplacement(String s, int k) {

        // Stores the longest valid substring length found
        int maxLength = 0;

        // Try every index as the starting position
        for (int i = 0; i < s.length(); i++) {

            // Fresh HashMap for every new starting position.
            // Key   = character
            // Value = frequency of that character
            HashMap<Character, Integer> freq = new HashMap<>();

            // Highest frequency of any character
            // in the current substring
            int maxFreq = 0;

            // Start from i and expand toward the right
            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);

                // Increase frequency of current character
                freq.put(
                    ch,
                    freq.getOrDefault(ch, 0) + 1
                );

                // Compare current character's frequency
                // with the highest frequency seen so far
                maxFreq = Math.max(
                    maxFreq,
                    freq.get(ch)
                );

                // Length of current substring from i to j
                int currentLength = j - i + 1;

                // Keep the most frequent character as it is.
                // All other characters need to be replaced.
                int replacements = currentLength - maxFreq;

                // If replacements are within our allowed k,
                // this is a valid substring
                if (replacements <= k) {

                    // Remember the longest valid length
                    maxLength = Math.max(
                        maxLength,
                        currentLength
                    );

                } else {

                    // Need more than k replacements.
                    // Stop checking substrings starting from this i.
                    // Outer loop will move to i + 1.
                    break;
                }
            }
        }

        return maxLength;
    }
}
*/
//"Best character frequency that has allowed me to achieve my best window size so far." ✅
class Solution {
    public int characterReplacement(String s, int k) {

        // Frequency of A-Z inside the current window
        int[] count = new int[26];

        // Left side of the sliding window
        int left = 0;

        // Highest frequency of any single character seen
        int maxFreq = 0;

        // Best answer found
        int maxLength = 0;

        // Expand the window using right
        for (int right = 0; right < s.length(); right++) {

            // Convert character to index 0-25
            int index = s.charAt(right) - 'A';

            // Add current character to the window
            count[index]++;

            // Update highest frequency seen
            maxFreq = Math.max(maxFreq, count[index]);

            // If too many characters need replacement,
            // shrink the window from the left
            while ((right - left + 1) - maxFreq > k) {

                // Character at left is leaving the window,
                // so reduce its frequency
                count[s.charAt(left) - 'A']--;

                // Move left forward
                left++;
            }

            // Current window is acceptable,
            // so update the maximum length
            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}
/*We already proved the old maximum length using the old maxFreq. If actual frequencies later decrease, we don't care about recalculating maxFreq downward because that cannot help us beat the old maximum. We only care when some character's frequency becomes even higher, because that's what can allow us to find a new, larger maximum length.*/