class Solution {
    boolean solve(String s,int i, int j, int[][]dp){
        if(i>j){
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;
        if(s.charAt(i)==s.charAt(j)){
            boolean res= solve(s,i+1,j-1,dp);
            dp[i][j]= res?1:0;
            return res;
        }
        return false;
    }
    public String longestPalindrome(String s) {
        int n= s.length();
        int dp[][] = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int max=0;
        int sp=0;
        int ep=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s,i,j,dp)){
                   int len = j - i + 1;
                    if (len > max) {
                        max = len;
                        sp = i;
                        ep = j;
                    }
                }
            }
        }
        String sub = s.substring(sp, ep+1);
        return sub;
    }
}