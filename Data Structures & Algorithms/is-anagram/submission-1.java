class Solution {
    public boolean isAnagram(String s, String t) {
                if(s.length()!= t.length()){
                    return false;
                }
   int[] count =new int[26];
   for(int i=0;i<s.length();i++){
    // // s.charAt(i) - 'a' converts a character into an index.
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
   }
    for (int num : count) {
        //Go through every element/value inside the count array, one by one, and temporarily store the current value in num.
            if (num != 0) {
                return false;
            }
        }

        return true;

/*
                char[] a= s.toCharArray();
                char[] b= t.toCharArray();
//sorting using Array.sort takes O(nlogn) where n is the size.
//SPACE complexity is O(n+m) y bcoz we are creating character arrays.
                Arrays.sort(a);
                Arrays.sort(b);

        return Arrays.equals(a,b);*/
    }
}
