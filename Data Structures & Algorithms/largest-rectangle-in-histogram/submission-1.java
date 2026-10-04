
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

/*For each bar, we assume that bar’s height is the rectangle’s height:
area = height of current bar × width

The current bar can extend:
- Left while bars are greater than or equal to its height.
- Right while bars are greater than or equal to its height.
The first smaller bar on each side becomes the boundary and is not included.
So we find:
left[i]  = nearest smaller bar on the left
right[i] = nearest smaller bar on the right

Then:
width = right[i] - left[i] - 1
area  = heights[i] × width

We calculate this area for every bar and keep the maximum.*/