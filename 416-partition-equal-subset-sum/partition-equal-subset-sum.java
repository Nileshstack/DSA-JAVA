class Solution {
    public boolean solve(int[] arr, int i,int curr, int target, int dp[][]){
        if(curr==target){
            return true;
        }
        if(i>=arr.length || curr > target) return false;
        if(dp[i][curr]!=-1) return dp[i][curr]==1;
        boolean take = solve(arr,i+1,arr[i]+curr,target,dp);
        boolean skip= solve(arr,i+1,curr,target,dp);
        boolean ans = take||skip;
        dp[i][curr]=ans?1:0;
        return ans;
    }
    public boolean canPartition(int[] arr) {
        int s=0;
        int n= arr.length;
        for(int i=0;i<n;i++){
            s+=arr[i];
        }
        if(s%2!=0) return false;
        int target = s/2;
        int dp[][] = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(arr,0,0,target,dp);
    }
}