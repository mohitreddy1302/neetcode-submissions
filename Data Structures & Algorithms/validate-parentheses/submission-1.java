

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Push opening brackets onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            // Process closing brackets
            else {

                // No opening bracket to match
                if (stack.isEmpty()) {
                    return false;
                }

                // Remove the most recently opened bracket
                char opening = stack.pop();

                // Check whether the brackets match
                if ((c == ')' && opening != '(') ||
                    (c == ']' && opening != '[') ||
                    (c == '}' && opening != '{')) {
                    return false;
                }
            }
        }

        // Stack must be empty if all brackets were matched
        return stack.isEmpty();
    }
}