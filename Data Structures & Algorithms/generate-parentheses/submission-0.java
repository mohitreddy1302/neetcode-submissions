class Solution {
    public List<String> generateParenthesis(int n) {
        // Every finished, well-formed string is stored here
        List<String> result = new ArrayList<String>();

        // Start with an empty string and no parentheses used yet
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    // open: how many '(' are placed so far
    // close: how many ')' are placed so far
    // current: the string built so far
    // result: all well-formed strings found
    private void backtrack(int n, int open, int close, StringBuilder current, List<String> result) {
        // Base case: used all n pairs, so the string is complete
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Rule 1: we may add '(' as long as we have not used all n of them
        if (open < n) {
            current.append('(');
            backtrack(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);   // undo
        }

        // Rule 2: we may add ')' only if it closes an open '(' that is still unmatched
        if (close < open) {
            current.append(')');
            backtrack(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);   // undo
        }
    }
}