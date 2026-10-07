class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        /*
         * We always perform binary search on the smaller array.
         *
         * This keeps the time complexity:
         * O(log(min(n1, n2)))
         */
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        /*
         * low and high represent the possible partition positions
         * in nums1.
         *
         * A partition position can range from 0 to n1.
         */
        int low = 0;
        int high = n1;

        /*
         * Number of elements that should be present
         * on the left side of the combined arrays.
         *
         * Adding 1 helps handle odd total lengths.
         */
        int leftSize = (n1 + n2 + 1) / 2;

        int totalSize = n1 + n2;

        while (low <= high) {

            /*
             * mid1 = number of elements taken from nums1
             * for the left half.
             */
            int mid1 = low + (high - low) / 2;

            /*
             * mid2 = number of elements taken from nums2
             * for the left half.
             */
            int mid2 = leftSize - mid1;

            /*
             * l1 = largest element on the left side of nums1
             * l2 = largest element on the left side of nums2
             *
             * If the partition is at the beginning of an array,
             * there is no left element, so use Integer.MIN_VALUE.
             */
            int l1 = (mid1 > 0)
                    ? nums1[mid1 - 1]
                    : Integer.MIN_VALUE;

            int l2 = (mid2 > 0)
                    ? nums2[mid2 - 1]
                    : Integer.MIN_VALUE;

            /*
             * r1 = smallest element on the right side of nums1
             * r2 = smallest element on the right side of nums2
             *
             * If the partition is at the end of an array,
             * there is no right element, so use Integer.MAX_VALUE.
             */
            int r1 = (mid1 < n1)
                    ? nums1[mid1]
                    : Integer.MAX_VALUE;

            int r2 = (mid2 < n2)
                    ? nums2[mid2]
                    : Integer.MAX_VALUE;

            /*
             * The partition is correct when:
             *
             * l1 <= r2
             * l2 <= r1
             *
             * This means every element on the left side
             * is less than or equal to every element on the right side.
             */
            if (l1 <= r2 && l2 <= r1) {

                /*
                 * If the total number of elements is odd,
                 * the median is the largest element on the left side.
                 */
                if (totalSize % 2 == 1) {
                    return Math.max(l1, l2);
                }

                /*
                 * If the total number of elements is even,
                 * the median is the average of:
                 *
                 * 1. Largest element on the left side
                 * 2. Smallest element on the right side
                 */
                int leftMaximum = Math.max(l1, l2);
                int rightMinimum = Math.min(r1, r2);

                return ((double) leftMaximum + rightMinimum) / 2.0;
            }

            /*
             * If l1 > r2, we selected too many elements
             * from nums1 for the left side.
             *
             * Move the partition in nums1 to the left.
             */
            else if (l1 > r2) {
                high = mid1 - 1;
            }

            /*
             * Otherwise, we selected too few elements
             * from nums1 for the left side.
             *
             * Move the partition in nums1 to the right.
             */
            else {
                low = mid1 + 1;
            }
        }

        /*
         * The input arrays are guaranteed to be sorted,
         * so a valid partition must always be found.
         */
        return 0.0;
    }
}