class Solution {
    public int solve(int i,int prev, int[] nums,int[][] dp){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        //take- i th ele
        int take=0;
        if(prev==-1 || nums[prev]<nums[i]){
            take =1+solve(i+1,i,nums,dp);
        }
        //skip this step
        int skip = solve(i+1,prev,nums,dp);
        return dp[i][prev+1]= Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
       int[][] dp = new int[n][n + 1];
        for (int[] row : dp){
        Arrays.fill(row, -1);
        }
        return solve(0,-1,nums,dp);
    }
}