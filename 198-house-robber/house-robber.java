class Solution {
    public int rob(int[] nums) {
        //Bottom-up approach
        int n=nums.length;
        int []dp= new int[n+1];
        Arrays.fill(dp,0);
        dp[0]=0;//No house is steeled;
        dp[1]= nums[0];//House 1 is steeled
        for(int i=2;i<=n;i++){
            int steel=nums[i-1]+dp[i-2];
            int skip=dp[i-1];
            dp[i]=Math.max(steel,skip);
        }   
        return dp[n];
    }
}