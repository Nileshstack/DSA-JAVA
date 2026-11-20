class Solution {
    double[][][] dp;
    public double solve(int n, int k, int r, int c,double[][][]dp){
        if(r<0 || r>=n || c<0 || c>=n) return 0;
        if(k==0) return 1;
        double ans =0;
        if (dp[r][c][k] != -1)
            return dp[r][c][k];
        int [][] directions= {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        for(int [] dir : directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            ans += (double)solve(n,k-1,nr,nc,dp);
        }
        return dp[r][c][k]=(double) ans/(8.0);
    }
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m <= k; m++) {
                    dp[i][j][m] = -1;
                }
            }
        }
        return solve(n,k,row,column,dp);
    }
}