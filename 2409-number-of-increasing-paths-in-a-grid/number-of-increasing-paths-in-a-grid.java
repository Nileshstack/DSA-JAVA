class Solution {
    static final int MOD = 1000000007;
    public int solve(int i, int j, int[][] grid, int dp[][]){
        int n= grid.length;
        int m = grid[0].length;
        int result =1;
        if(dp[i][j]!=-1) return dp[i][j];
        int direction[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int []dir : direction){
            int newi= i+dir[0];
            int newj=j+dir[1];
            if(newi<n && newi>=0 && newj<m && newj >=0 && grid[i][j]>grid[newi][newj]){
                result=(result+solve(newi,newj,grid,dp))% MOD;
            }
        } 
        return dp[i][j]= result;
    }
    public int countPaths(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        } 
        int result =0;
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                result = (result + solve(i,j,grid,dp)) % MOD;
            }
        }
        return result;
    }
}