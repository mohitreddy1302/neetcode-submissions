class Solution {
    public String minWindow(String s, String t) {

        int[] required = new int[128];
        int[] window = new int[128];

        // Count how many times each character is needed from t
        for (char c : t.toCharArray()) {
            required[c]++;
        }

        int left = 0;
        int have = 0;
        int need = t.length();

        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        // Move the right side of the window through s
        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            window[rightChar]++;

            // This character satisfies a needed character
            if (window[rightChar] <= required[rightChar]) {
                have++;
            }

            // Once the window contains all characters from t
            while (have == need) {

                int currentLength = right - left + 1;

                // Save the shortest valid window
                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestStart = left;
                }

                // Remove the leftmost character
                char leftChar = s.charAt(left);
                window[leftChar]--;

                // The window is no longer valid if a required
                // character count becomes too small
                if (window[leftChar] < required[leftChar]) {
                    have--;
                }

                left++;
            }
        }

        // No valid window was found
        if (bestLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(bestStart, bestStart + bestLength);
    }
}
/*class Solution {
    public String minWindow(String s, String t) {

        int[] required = new int[128];

        // Count the characters required from t
        for (char c : t.toCharArray()) {
            required[c]++;
        }

        String answer = "";

        // Choose the starting position
        for (int left = 0; left < s.length(); left++) {

            int[] window = new int[128];

            // Choose the ending position
            for (int right = left; right < s.length(); right++) {

                // Add the new character to the current substring
                window[s.charAt(right)]++;

                // Check whether this substring contains all t characters
                if (containsAll(window, required)) {

                    String current = s.substring(left, right + 1);

                    // Save it if it is the first valid substring
                    // or shorter than the previous answer
                    if (answer.isEmpty() ||
                        current.length() < answer.length()) {
                        answer = current;
                    }
                }
            }
        }

        return answer;
    }

    private boolean containsAll(int[] window, int[] required) {

        for (int i = 0; i < 128; i++) {
            if (window[i] < required[i]) {
                return false;
            }
        }

        return true;
    }
}*/


/*Yes, that is exactly how it works.

In simple terms:

Keep adding characters by moving right.
Update have whenever a character satisfies a requirement.

When:

have == need

the window is valid.

Calculate its length and store its starting position before changing it.
Remove characters from the left one by one to make the window smaller.
If the window remains valid, continue removing.

When a required character becomes insufficient, decrease have:

have--;
The while loop stops.
Move right forward again to find another valid window.
The earlier valid windows are not lost because their information is stored in:
bestStart
bestLength

Your understanding is correct.*/