class Solution {
    public int solve(int[] arr, int i,int s,int t, int dp[][]){
       if (i == arr.length) {
         return s == t ? 1 : 0;
        }
        if (s > t) return 0;
        if(dp[i][s]!=-1) return dp[i][s];
        int take = solve(arr,i+1,s+arr[i],t,dp);
        int skip = solve(arr,i+1,s,t,dp);
        return dp[i][s]=take+skip;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int s= 0;
        int n= nums.length;
        for(int i =0;i<n;i++){
            s+=nums[i];
        }
        if (Math.abs(target) > s) return 0;
        if ((s + target) % 2 != 0) return 0;
        int t= (s+target)/2;
    
        int [][]dp= new int [n][t+1]; 
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,0,t,dp);
    }
}