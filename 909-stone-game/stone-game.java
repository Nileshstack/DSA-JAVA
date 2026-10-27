class Solution {
    public int solve(int []arr, int i, int j, int dp[][]){
        if(i>=arr.length || j<=0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int front = arr[i]+solve(arr,i+1,j,dp);
        int back = arr[j]+solve(arr,i,j-1,dp);
        return dp[i][j]=Math.max(front,back);
    }
    public boolean stoneGame(int[] piles) {
        int s=0;
        for(int p : piles){
            s+=p;
        }
        int l= piles.length;
        int [][] dp = new int[l][l];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int n = solve(piles,0,l-1,dp);
        if(n > s/2){
            return true;
        }
        return false;
    }
}