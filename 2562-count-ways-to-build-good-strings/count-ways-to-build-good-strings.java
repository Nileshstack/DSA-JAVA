class Solution {
    int MOD = 1_000_000_007;
    public int solve(int l, int h, int z, int o, int len, int[]dp){
        if(len>h) return 0;
        if(dp[len]!=-1) return dp[len];
        boolean valid = false;
        if(l<= len && h>=len){
            valid = true;
        }
        int addOne = solve(l,h,z,o,len+o,dp);
        int addZero = solve(l,h,z,o,len+z,dp);
        return dp[len]=valid?(1+addOne+addZero)%MOD : (addOne+addZero)%MOD;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[]= new int[high+1];
        Arrays.fill(dp,-1);
        return solve(low,high,zero,one,0,dp);
    }
}