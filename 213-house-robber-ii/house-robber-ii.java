class Solution {
    public int rob(int[] nums) {
       int n= nums.length;
        if(n==1){
            return nums[0];
        }
        int []dp= new int[n+1];
        Arrays.fill(dp,0);
        dp[0]=0;
        for(int i=1;i<=n-1;i++){
            int skip = dp[i-1];
            int take = nums[i-1]+((i-2)>=0?dp[i-2]:0);
            dp[i] = Math.max(skip, take);
        }
        int res1=dp[n-1];
        Arrays.fill(dp,0);
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            int skip = dp[i-1];
            int take = nums[i-1]+((i-2)>=0?dp[i-2]:0);
            dp[i] = Math.max(skip, take);
        }
        int res2=dp[n];
        return Math.max(res1,res2);
    }
}