class Solution {
    public boolean containsDuplicate(int[] nums) {
       Set <Integer> set = new HashSet<>();
       for(int i=0;i<nums.length;i++){
        if(!set.add(nums[i])){ //return false idf alredy exist
            return true;
        }
       }
       return false; 
    }
}