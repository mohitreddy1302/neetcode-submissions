class Solution {
    //This method returns an int[] array (technically, a reference to an int[] object).
    public int[] twoSum(int[] nums, int target) {
        /*for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                return new int[]{i,j};
//time complexity is o(n^2) and space complexity is o(1) bcoz we are not creating any data structure that grows with input size.
                }
            }
        }
        return null;*/

java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

for(int i=0;i<nums.length;i++){
    int needed=target-nums[i];

    if(map.containsKey(needed)){
        return new int[]{map.get(needed),i};
    }
    map.put(nums[i],i);
}
return null;

//time complexity is o(n),Space is O(n) because in the worst case, we may store almost every number in the HashMap.


    }
}