class Solution {
    public int majorityElement(int[] nums) {
        int l = nums.length/2;
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<nums.length;i++){
          if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                
                freq.put(nums[i], 1);
            }
        }
        for (int key : freq.keySet()) {
             if (freq.get(key) > l) {
                return key;  // return element itself
            }
        }
         
        return -1;
    }
}