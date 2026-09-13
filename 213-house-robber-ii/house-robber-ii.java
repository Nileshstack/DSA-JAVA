class Solution {
     public int solve(int[]nums,int []dp, int i,int n){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int steel= nums[i]+solve(nums,dp,i+2,n);
        int skip=solve(nums,dp,i+1,n);
        return dp[i]=Math.max(steel,skip);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int[]dp1= new int[n+1];
        Arrays.fill(dp1,-1);
        int[]dp2= new int[n+1];
        Arrays.fill(dp2,-1);
        int SteelFirstHouse= solve(nums,dp1,0,n-1);
        int SteelSecondhouse= solve(nums,dp2,1,n);
        return Math.max(SteelFirstHouse,SteelSecondhouse);
    }
}