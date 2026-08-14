class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            // Width between the two bars
            int width = right - left;

            // Water height is limited by the shorter bar
            int h = Math.min(height[left], height[right]);

            // Current area
            int area = width * h;

            // Keep the maximum area
            maxArea = Math.max(maxArea, area);

            // Move the shorter bar inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}