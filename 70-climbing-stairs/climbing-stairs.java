class Solution {
    public int solve(int n,int[] dp){
        if(n<0) return 0;
        if (n==0)return 1;
        if(dp[n]!=0) return dp[n];
        int st1=solve(n-1,dp);
        int st2=solve(n-2,dp);
        
        return dp[n]=st1+st2;
    }
    public int climbStairs(int n) {
        if(n==1) return 1;
        int []dp=new int[n+1];
        Arrays.fill(dp,0);
        return solve(n,dp);
    }
}