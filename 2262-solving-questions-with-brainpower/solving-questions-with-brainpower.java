class Solution {
    public long solve(int[][] que, int i,long[] dp){
        if(i>= que.length) return 0;
        if(dp[i]!=-1) return dp[i];

        long take= que[i][0]+solve(que,i+1+que[i][1],dp);
        long skip = solve(que,i+1,dp);
        return dp[i]= Math.max(take,skip);
    }
    public long mostPoints(int[][] questions) {
        long []dp = new long[questions.length];
            Arrays.fill(dp,-1);
        
        return solve(questions,0,dp);
    }
}