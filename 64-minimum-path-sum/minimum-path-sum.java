class Solution {
    public int solve(int i,int j,int n, int m,int[][] grid,int[][]dp){
        
        if(i<0 ||i>=n || j<0||j>=m){
            return Integer.MAX_VALUE/2;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==n-1&&j==m-1){
            return grid[i][j];
        }
        int right = grid[i][j]+solve(i,j+1,n,m,grid,dp);
        int down = grid[i][j]+solve(i+1,j,n,m,grid,dp);
        return dp[i][j]=Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
      return solve(0,0,n,m,grid,dp);   
    }
}