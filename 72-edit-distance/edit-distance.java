class Solution {
    public int solve(String s1, String s2, int i,int j,int dp[][]){
        int n= s1.length();
        int m= s2.length();
       
        //we have to add remaing word of s2 in s1.
        if(i==n){
            return m-j;
        }
        //we have to remove remainging word from s1 as s2 finished.
        if(j==m){
            return n-i;
        }
         if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= solve(s1,s2,i+1,j+1,dp);
        }else{
            return dp[i][j]= 1+Math.min(solve(s1,s2,i,j+1,dp),Math.min(solve(s1,s2,i+1,j,dp),solve(s1,s2,i+1,j+1,dp)));
        }
    }
    public int minDistance(String s1, String s2) {
        int dp[][]= new int[s1.length()][s2.length()];
       for (int[] row : dp) {
            Arrays.fill(row, -1);
            }
        return solve(s1,s2,0,0,dp);
    }
}