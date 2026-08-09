class Solution {
    public int[] productExceptSelf(int[] nums) {

       /* int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] output = new int[n];

        // Build prefix products
        prefix[0] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Build suffix products
        suffix[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Left product × right product
        for (int i = 0; i < n; i++) {
            output[i] = prefix[i] * suffix[i];
        }

        return output;*/
        int n = nums.length;
        int[] output = new int[n];

        // Store prefix products directly in output
        int prefix = 1;

        for (int i = 0; i < n; i++) {
            output[i] = prefix;     // product of everything to the left
            prefix *= nums[i];
        }

        // Multiply suffix products into output
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix;    // left product * right product
            suffix *= nums[i];
        }

        return output;
    }
    }
