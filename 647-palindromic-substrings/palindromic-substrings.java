class Solution {
    //After Memoization
    public boolean check(int i,int j,String s,int dp[][]){
        if(i>j){
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;
        if(s.charAt(i)==s.charAt(j)){
            boolean result=check(i+1,j-1,s,dp);
            dp[i][j] = result ? 1 : 0;
            return result;
        }
        return false;
    }
    public int countSubstrings(String s) {
        int n= s.length();
        int dp[][] = new int[n][n];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(i,j,s,dp)){
                    c++;
                }
            }
        }
        return c;
    }
}