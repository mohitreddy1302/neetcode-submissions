
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     /*   List<List<String>> result= new ArrayList<>();
  // Keeps track of strings that are already placed in a group
        boolean[] used = new boolean[strs.length];


        for (int i = 0; i < strs.length; i++) {

            if (used[i]) {
                continue;
            }

      
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i] = true;

    
            for (int j = i + 1; j < strs.length; j++) {

          
                if (used[j]) {
                    continue;
                }

                if (isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }
            result.add(group);
        }

        return result;
    }

    private boolean isAnagram(String s, String t) {


        if (s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();


        Arrays.sort(a);
        Arrays.sort(b);


        return Arrays.equals(a, b);
/*Time: O(n² × k log k) — nested loops give n², and sorting each string takes k log k.*
Space: O(n + k) — used[] takes n, temporary character arrays take k./

*/
   // Key   = sorted version of a word
        // Value = list of words having that same sorted version
        //
        // Example:
        // "act"  -> ["act", "cat"]
        // "opst" -> ["pots", "tops", "stop"]
        HashMap<String, List<String>> map = new HashMap<>();

        // Go through every word
        for (String word : strs) {

            // Convert String to char array
            // Example: "cat" -> ['c', 'a', 't']
            char[] chars = word.toCharArray();

            // Sort the characters
            // Example: ['c', 'a', 't'] -> ['a', 'c', 't']
            Arrays.sort(chars);

            // Convert sorted char array back to String
            // Example: ['a', 'c', 't'] -> "act"
            String key = new String(chars);

            // If this key doesn't exist,
            // create a new empty list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the ORIGINAL word to its anagram group
            //
            // Example:
            // key  = "act"
            // word = "cat"
            //
            // "act" -> ["act", "cat"]
            map.get(key).add(word);
        }

        // Return all the anagram groups
        return new ArrayList<>(map.values());
    }
}
