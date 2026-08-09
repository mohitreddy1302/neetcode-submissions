class Solution {
// word i keep is in this format lenght#word
    public String encode(List<String> strs) {
            StringBuilder encoded =new StringBuilder();
            for(String word: strs){
                encoded.append(word.length());
                encoded.append("#");
                encoded.append(word);
            }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();
                int i=0;
        while(i<str.length()){
                int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
             // Characters from i to j contain the length
            int length = Integer.parseInt(str.substring(i, j));
              // Actual word starts after '#'
            int start = j + 1;
               // Take exactly 'length' characters
            String word = str.substring(start, start + length);

            result.add(word);
            // Move i to the beginning of the next encoded word
            i = start + length;

        }
        return result;
    }
}
/*“A simple delimiter alone won't work because the delimiter can appear inside the strings. So I'll encode each string using its length followed by a delimiter, like 5#Hello.”*/
/*“The time complexity is O(n) because we process each character in the input once while encoding and decoding. Even though decode has a nested loop, we don't repeatedly scan the same characters.

The space complexity is O(n) because we create a new encoded string during encoding and recreate the original strings/list during decoding.”*/