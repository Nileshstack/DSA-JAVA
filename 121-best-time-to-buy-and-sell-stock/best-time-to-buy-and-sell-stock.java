class Solution {
    public int maxProfit(int[] nums) {
        int buy=nums[0];
        int maxp=0;
        int currp=0;
        for(int i=1;i<nums.length;i++){
            if(buy>nums[i]){
                buy=nums[i];
            }else{
                int profit= nums[i]-buy;
                if(profit>currp){
                    currp=profit;
                }
            }
            maxp=Math.max(currp,maxp);
        }
        return maxp;
    }
}