class Solution {
    public int solve(int i,int j,int n, int m,int arr[][], int[][]dp){
        if(i==n-1&&j==m-1){
            return 1;
        }        
        if(i<0 || i>=n || j<0 || j>=m || arr[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int right = solve(i,j+1,n,m,arr,dp);
        int left= solve(i+1,j,n,m,arr,dp);
        return dp[i][j]=left+right;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
         int n= arr.length;
        int m= arr[0].length;
        if(arr[n-1][m-1]==1 || arr[0][0]==1){
            return 0;
        }
        int dp[][]= new int[n][m];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,n,m,arr,dp);
    }
}