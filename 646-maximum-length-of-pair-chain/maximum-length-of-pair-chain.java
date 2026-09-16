class Solution {
    public int solve(int i,int p,int[][]pairs,int dp[][]){
        if(i ==pairs.length) return 0;
        int take =0;
        if(dp[i][p+1]!=-1) return dp[i][p+1];
        if(p==-1||pairs[p][1]<pairs[i][0]){
            take = 1+ solve(i+1,i,pairs,dp); 
        }
        int skip= solve(i+1,p,pairs,dp);
        return dp[i][p+1]= Math.max(take,skip);
    } 
    public int findLongestChain(int[][] pairs) {
       Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
       int n=pairs.length;
       int dp[][] = new int[n][n+1];
       for(int[]row : dp ){
        Arrays.fill(row,-1);
       }
       return solve(0,-1,pairs,dp) ;
    }
}