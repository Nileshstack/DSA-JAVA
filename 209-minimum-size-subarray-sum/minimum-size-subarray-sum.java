class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int min = Integer.MAX_VALUE;
      int currsum=0;
      int l=0;int r=0;
      while(r<nums.length){
        currsum+=nums[r];
        r++;
        while(currsum>=target){
           int currWindow=r-l;
           min=Math.min(min,currWindow);
           currsum-=nums[l];
           l++;
        }
      } 
      return min == Integer.MAX_VALUE?0:min;
    }
}