
class Solution {
    // Letters for digits 2 through 9. Index 0 and 1 are unused (no letters).
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        // Empty input has no combinations, so return an empty list
        if (digits.length() == 0) {
            return result;
        }

        // Start with an empty prefix and the first digit position
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    // index: which digit we are handling now
    // current: the letters chosen so far
    // result: all finished combinations
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: one letter chosen for every digit, so save the combination
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // The letters this digit can stand for
        String letters = MAP[digits.charAt(index) - '0'];

        // Choose each letter, explore the next digit, then undo the choice
        for (int k = 0; k < letters.length(); k++) {
            current.append(letters.charAt(k));          // choose
            backtrack(digits, index + 1, current, result); // explore
            current.deleteCharAt(current.length() - 1); // undo
        }
    }
}