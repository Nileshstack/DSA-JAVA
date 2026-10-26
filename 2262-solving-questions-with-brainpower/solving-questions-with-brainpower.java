class Solution {
    public long solve(int[][] que, int i,long[] dp){
        if(i>= que.length) return 0;
        if(dp[i]!=-1) return dp[i];

        long take= que[i][0]+solve(que,i+1+que[i][1],dp);
        long skip = solve(que,i+1,dp);
        return dp[i]= Math.max(take,skip);
    }
    public long mostPoints(int[][] que) {
        long []dp = new long[que.length];
        for(int j = que.length-1;j>=0;j--){
            long take=que[j][0];
            if(j+1+que[j][1]<que.length){
                take+=dp[j+1+que[j][1]];
            }
            long skip=0;
            if(j<que.length-1){
                skip= dp[j+1];
            }

            dp[j]= Math.max(take,skip);
        }
            return dp[0];
    }

}