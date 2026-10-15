class Solution {
    public boolean solve(String s, String t,int i,int j,int dp[][]){
        if (i == s.length()) return true;
        if (j == t.length()) return false;

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans;

        if (s.charAt(i) == t.charAt(j)) {
            ans = solve(s, t, i + 1, j + 1, dp);
        } else {
            ans = solve(s, t, i, j + 1, dp);
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
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