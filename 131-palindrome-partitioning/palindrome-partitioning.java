class Solution {
    public void solve(String s, int i,List<String> curr, List<List<String>> ans,boolean[][] dp){
        if(i==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(dp[i][j]){
                curr.add(s.substring(i,j+1));
                solve(s,j+1,curr,ans,dp);
                curr.remove(curr.size() - 1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        int n= s.length();

        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]= true;
        }
        for(int L=2;L<=n;L++){
            for(int i=0;i<n-L+1;i++){
                int j= i+L-1;
                if(s.charAt(i)==s.charAt(j)){
                if(L==2){
                    dp[i][j]= true;
                }else{
                    dp[i][j]=dp[i+1][j-1];
                }
                }
            }
        }
         List<List<String>> ans = new LinkedList<>();
         List<String> curr= new LinkedList<>();

        solve(s,0,curr,ans,dp);
        return ans;
    }
}