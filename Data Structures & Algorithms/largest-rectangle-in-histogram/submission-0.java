
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Find the nearest smaller element on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        // Clear the stack
        while (!stack.isEmpty()) {
            stack.pop();
        }

        // Find the nearest smaller element on the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        int answer = 0;

        // Calculate the maximum area
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int currentArea = heights[i] * width;

            answer = Math.max(answer, currentArea);
        }

        return answer;
    }
}