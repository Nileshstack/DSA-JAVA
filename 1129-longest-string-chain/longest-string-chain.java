class Solution {
    public boolean CheckPredesor(String a , String b){
        int n= a.length();
        int m= b.length();
        if(m!=n-1) return false;
        int i=0,j=0;
        while(i<n){
            if(j < m && a.charAt(i) == b.charAt(j)){
               i++; 
               j++;
            }
            else{
                i++;
            }
        }
        return j==m;
    }
    public int solve(int i,int p,String []words, int[][]dp){
        if(i==words.length) return 0;
        if(dp[i][p+1]!= -1) return dp[i][p+1];
        int take=0;
        if(p==-1 || CheckPredesor(words[i],words[p])){
            take=1+solve(i+1,i,words,dp);
        }
        int skip=solve(i+1,p,words,dp);
        return dp[i][p+1]=Math.max(take,skip);
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n= words.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp){
        Arrays.fill(row, -1);
        }
       return solve(0,-1,words,dp); 
    }
}