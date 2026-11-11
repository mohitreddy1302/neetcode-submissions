class Solution {
    public boolean checkValidString(String s) {
        // Range of possible counts of unmatched '('
        int lo = 0;   // fewest unmatched '(' possible
        int hi = 0;   // most unmatched '(' possible

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lo++;  
                hi++;   
            } else if (c == ')') {
                lo--;
                hi--;
            } else {
                // '*' can be ')' (lo goes down), '(' (hi goes up), or empty (no change)
                lo--;
                hi++;
            }

            // lo can't go negative: an extra ')' from a '*' just means that choice was empty
            if (lo < 0) {
                lo = 0;
            }

            // Even treating every '*' as '(' there are too many ')'
            if (hi < 0) {
                return false;
            }
        }

        // Valid only if some choice leaves zero unmatched '('
        return lo == 0;
    }
}