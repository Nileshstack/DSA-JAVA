class Solution {
    public boolean solve(String s, String t,int i,int j,boolean dp[][]){
        if( j==t.length() && i<s.length() ){
            return false;
        }        
        if(i==s.length() && j<=t.length()){
            return true;
        }
        if(dp[i][j]) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= solve(s,t,i+1,j+1,dp);
        }else{
            return dp[i][j]=solve(s,t,i,j+1,dp);
        }
    }
    public boolean isSubsequence(String s, String t) {
        int n= s.length();
        int m = t.length();
        boolean [][]dp = new boolean[n][m];
        for(boolean[] row : dp){
            Arrays.fill(row,false);
        }
        return solve(s,t,0,0,dp);
    }
}