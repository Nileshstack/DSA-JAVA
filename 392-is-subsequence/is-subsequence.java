class Solution {
    public boolean solve(String s, String t,int i,int j,int dp[][]){
        if( j==t.length() && i<s.length() ){
            return false;
        }        
        if(i==s.length() && j<=t.length()){
            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = solve(s, t, i + 1, j + 1, dp) ? 1 : 0;
        } else {
            dp[i][j] = solve(s, t, i, j + 1, dp) ? 1 : 0;
        }

        return dp[i][j] == 1;
    }
    public boolean isSubsequence(String s, String t) {
        int n= s.length();
        int m = t.length();
        int [][]dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(s,t,0,0,dp);
    }
}