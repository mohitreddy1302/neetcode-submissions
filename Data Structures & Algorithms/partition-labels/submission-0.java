class Solution {
    public List<Integer> partitionLabels(String s) {
        // Record the last index where each letter appears
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<Integer>();
        int size = 0;   // length of the current partition
        int end = 0;    // furthest last-index of any letter seen in this partition

        for (int i = 0; i < s.length(); i++) {
            size++;
            // extend the partition to cover the last occurrence of this letter
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // every letter seen so far ends inside this partition, so cut here
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}