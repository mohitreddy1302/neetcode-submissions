

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        // Add the value to the normal stack
        stack.push(val);

        // If this is the first value, it is the minimum
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            // Store the smaller value between:
            // the current value and the previous minimum
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {

        // Remove from both stacks
        stack.pop();
        minStack.pop();
    }

    public int top() {

        // Return the top value from the normal stack
        return stack.peek();
    }

    public int getMin() {

        // The top of minStack is always the current minimum
        return minStack.peek();
    }
}