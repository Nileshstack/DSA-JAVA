class Solution {
    public boolean CheckPredesor(String a , String b){
        int n= a.length();
        int m= b.length();
        if(m!=n-1) return false;
        int i=0,j=0;
        while(i<n){
            if(j <  m && a.charAt(i) == b.charAt(j)){
               i++; 
               j++;
            }
            else{
                i++;
            }
        }
        return j==m;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n= words.length;
        int[]dp = new int[n];
        Arrays.fill(dp, 1);
        int m=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(CheckPredesor(words[i],words[j])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    m=Math.max(m,dp[i]);
                }
            }
        }
       return m; 
    }
}