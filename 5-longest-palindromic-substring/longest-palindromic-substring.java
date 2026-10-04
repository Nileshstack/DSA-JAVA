class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        boolean dp[][] = new boolean[n+1][n+1];
        for(boolean[] row : dp){
            Arrays.fill(row,false);
        }
        //creating the matreic with T and F value.
        for(int L=1;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j= i+L-1;
                if(i==j){
                    dp[i][j]= true;
                }
                else if(i+1==j){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else{
                    dp[i][j]=((s.charAt(i)==s.charAt(j))&& dp[i+1][j-1]);
                }
            }
        }
        //finding the starting and ending point
        int max=0;
        int sp=0;
        int ep=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]){
                    int len = j-i+1;
                    if(len>max){
                        max=len;
                        sp=i;
                        ep=j;
                    } 
                }
            }
        }
        return s.substring(sp,ep+1);
    }
}