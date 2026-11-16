class Solution {
    private int nextEvent(int[][] events, int i) {
        int low = i + 1;
        int high = events.length - 1;
        int ans = events.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (events[mid][0] > events[i][1]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
    public int solve(int[][] events, int i, int k, int [][] dp){
        int n = events.length;
        if(i>=n || k==0) return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        int skip =solve(events,i+1,k,dp);
        int take=events[i][2];
        int j = nextEvent(events, i);
        take +=solve(events,j,k-1,dp);
        return dp[i][k]= Math.max(take,skip);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a, b) -> Integer.compare(a[0], b[0]));
        int n= events.length;
        int dp[][] = new int[n][k+1];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(events,0,k,dp);
    }
}