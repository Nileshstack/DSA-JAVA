class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        //bottoms-up;
         int n= arr.length;
        int m= arr[0].length;
        if(arr[n-1][m-1]==1 || arr[0][0]==1){
            return 0;
        }
        int dp[][]= new int[n][m];
        for(int i=0;i<n;i++){
            if(arr[i][0]==1){
                break;
            }
            dp[i][0]=1;
        }
        for(int j=0;j<m;j++){
            if(arr[0][j]==1){
                break;
            }
            dp[0][j]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j==0||i==0){
                    continue;
                }
                if(arr[i][j]==1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}