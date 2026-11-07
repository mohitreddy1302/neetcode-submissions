
class Solution {
    public List<List<String>> partition(String s) {
        // Every finished partition (list of palindromes) is stored here
        List<List<String>> result = new ArrayList<List<String>>();

        // The palindromes chosen so far on the current path
        List<String> current = new ArrayList<String>();

        backtrack(s, 0, current, result);
        return result;
    }

    // start: index where the next substring begins (the "j" from the hint)
    // current: the palindromes chosen so far
    // result: all finished partitions
    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // Base case: we have split the whole string, so save a copy of this partition
        if (start == s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        }

        // Try every possible end for the next substring, from start to the last index
        for (int end = start; end < s.length(); end++) {
            // Only cut if s[start..end] is a palindrome
            if (isPalindrome(s, start, end)) {
                // Choose: the substring s[start..end] is the next piece
                current.add(s.substring(start, end + 1));

                // Explore: partition the rest of the string after end
                backtrack(s, end + 1, current, result);

                // Undo: remove the piece so the next end value starts from the same state
                current.remove(current.size() - 1);
            }
        }
    }

    // Checks whether s[left..right] reads the same forwards and backwards
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}