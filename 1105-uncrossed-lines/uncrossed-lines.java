class Solution {
    public int solve(int[] nums1, int[] nums2,int i, int j, int[][] dp){
        if(i>=nums1.length || j>=nums2.length){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(nums1[i]==nums2[j]){
            return dp[i][j]= 1+solve(nums1,nums2,i+1,j+1,dp);
        }else{
            int fix_i= solve(nums1,nums2,i+1,j,dp);
            int fix_j=solve(nums1,nums2,i,j+1,dp); 
            return dp[i][j]= Math.max(fix_i,fix_j);
        }

    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
       int n= nums1.length;
       int m = nums2.length;
       int [][] dp = new int[n][m];
       for(int i = n-1;i>=0;i--){
        for(int j= m-1;j>=0;j--){
            int take=0;
            if(nums1[i]==nums2[j]){
                 take =1;
                if(i+1<n && j+1<m){
                    take+= dp[i+1][j+1];
                }
            }
                    int fix_i=0;
                    int fix_j=0;
                    if(i+1<n){
                        fix_i= dp[i+1][j];
                    }
                    if(j+1<m){
                        fix_j=dp[i][j+1];
                    }
                    dp[i][j]= Math.max(take, Math.max(fix_i,fix_j));
                
            

        }
       } 
       return dp[0][0];
    }
}