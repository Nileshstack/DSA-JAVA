class Solution {
    public long solve(int idx,int flag,int[] nums,long[][]dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx][flag]!=-1){
            return dp[idx][flag];
        }
        long skip= solve(idx+1,flag,nums,dp);
        long val= nums[idx];
        if(flag==0){
            val=-val;
        }
        long take = val +solve(idx+1,1-flag,nums,dp);
        return dp[idx][flag]=Math.max(skip,take);
    }
    public long maxAlternatingSum(int[] nums) {
        long[][]dp = new long[nums.length+1][2];
        for (int i = 0; i < nums.length; i++) {
        Arrays.fill(dp[i], -1);
        }
        return solve(0,1,nums,dp);
    }
}