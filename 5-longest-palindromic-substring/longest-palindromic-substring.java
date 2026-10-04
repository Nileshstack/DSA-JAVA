class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        boolean dp[][] = new boolean[n+1][n+1];
        for(boolean[] row : dp){
            Arrays.fill(row,false);
        }
        int max=0;
        int sp=0;
        //creating the matreic with T and F value.
        for(int L=1;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j= i+L-1;
                if(i==j){
                    dp[i][j]= true;
                    max=1;
                }
                else if(i+1==j){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                    if(dp[i][j]){
                        max=2;
                       sp=i;
                    }
                }
                else{
                    dp[i][j]=((s.charAt(i)==s.charAt(j))&& dp[i+1][j-1]);
                    int len=j-i+1;
                    if(dp[i][j]){
                        if(len>max){
                        max=len;
                        sp=i;
                    }
                    }
                }
            }
        }
        return s.substring(sp,sp+max);
    }
}