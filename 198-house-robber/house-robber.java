class Solution {
    public int solve(int[]nums,int []dp, int i,int n){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int steel= nums[i]+solve(nums,dp,i+2,n);
        int skip=solve(nums,dp,i+1,n);
        return dp[i]=Math.max(steel,skip);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[]dp= new int[n+1];
        Arrays.fill(dp,-1);
     return solve(nums,dp,0,n);   
    }
}