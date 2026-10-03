class Solution {
    //After Memoization
    /*public boolean check(int i,int j,String s,int dp[][]){
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
    }*/
    public int countSubstrings(String s) {
        int n= s.length();
        boolean dp[][] = new boolean[n][n];
        for(boolean []row : dp){
            Arrays.fill(row,false);
        }
        int c=0;
        for(int L=1; L<=n ;L++){ //for every length like 1 "a",2->"aa",3->"aaa";
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;
                if(i==j){//single char string "a"
                    dp[i][j]=true;
                }
               else if(i+1==j){//double char String "aa"
                    dp[i][j]= (s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=((s.charAt(i)==s.charAt(j)) && dp[i+1][j-1]);
                }
                if(dp[i][j]==true){
                    c++;
                }
            }
        }
        return c;
    }
}