class Solution {
    public boolean isAnagram(String s, String t) {
                if(s.length()!= t.length()){
                    return false;
                }

                char[] a= s.toCharArray();
                char[] b= t.toCharArray();
//sorting using Array.sort takes O(nlogn) where n is the size.
//SPACE complexity is O(n+m) y bcoz we are creating character arrays.
                Arrays.sort(a);
                Arrays.sort(b);

        return Arrays.equals(a,b);
    }
}
