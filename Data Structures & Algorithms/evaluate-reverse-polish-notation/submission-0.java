

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // If token is an operator, calculate immediately
            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                // First popped value is the right operand
                int right = stack.pop();

                // Second popped value is the left operand
                int left = stack.pop();

                int result = 0;

                if (token.equals("+")) {
                    result = left + right;
                } else if (token.equals("-")) {
                    result = left - right;
                } else if (token.equals("*")) {
                    result = left * right;
                } else {
                    result = left / right;
                }

                // Store the result for future operations
                stack.push(result);
            }

            // If token is a number, push it onto the stack
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        // The final answer remains on the stack
        return stack.pop();
    }
}