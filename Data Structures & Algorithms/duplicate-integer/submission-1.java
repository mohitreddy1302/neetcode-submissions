
class Solution {
    public boolean hasDuplicate(int[] nums) {

        /*for (int i = 0; i < nums.length; i++) {

            int a = nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                if (a == nums[j]) {
                    return true;
                }
            }
        }

        return false;*/

        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }
}