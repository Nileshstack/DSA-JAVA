class Solution {
    
    public int findLongestChain(int[][] pairs) {
       Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
       int n=pairs.length;
       if(pairs.length == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
       int m= 1;
       for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
            if(pairs[j][1]<pairs[i][0]){
                dp[i]= Math.max(dp[i],dp[j]+1);
                m= Math.max(m,dp[i]);
            }
        }
       }
       return m;
    }
}