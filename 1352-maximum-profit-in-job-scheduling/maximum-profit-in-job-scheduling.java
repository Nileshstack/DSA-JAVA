class Solution {
    public int findNextindex(int[][]arr, int start, int end ){
        int low = start;
        int high = arr.length - 1;
        int ans = arr.length;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid][0] >= end) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return ans;
    }
    public int solve(int i, int[][]arr,int[]dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int nextIdx= findNextindex(arr,i+1,arr[i][1]);
        int taken = arr[i][2]+solve(nextIdx,arr,dp);
        int skip= solve(i+1,arr,dp);
        return dp[i]=Math.max(taken,skip);
    }
    public int jobScheduling(int[] st, int[] et, int[] profit) {
        int arr[][]= new int[st.length][3];
        for(int i=0;i<st.length;i++){
            arr[i][0]=st[i];
            arr[i][1]=et[i];
            arr[i][2]=profit[i];
        }
        int dp[]= new int[st.length];
        Arrays.fill(dp,-1);
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));
        return solve(0,arr,dp);
    }
}