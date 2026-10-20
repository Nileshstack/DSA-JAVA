class Solution {
    public boolean solve(int[]nums,int i,int[] dp){
        if(i>=nums.length-1) return true;
        if(dp[i]!=-1) return dp[i]==1;
        for(int j=1;j<=nums[i];j++){
            if (solve(nums, i + j,dp)) {
                dp[i]=1;
            return true;
        }
        }
        dp[i]=0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
}