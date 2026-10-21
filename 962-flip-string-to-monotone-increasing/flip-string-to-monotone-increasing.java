class Solution {
    public int solve(String s,int curr, int prev, int [][]dp){
       if(curr>=s.length()){
        return 0 ;
       }
       if(dp[curr][prev]!=-1) return dp[curr][prev];
       int flip= Integer.MAX_VALUE/2;
       int noflip= Integer.MAX_VALUE/2;
      if(s.charAt(curr)=='1'){
            if(prev==0){
               flip = 1+solve(s,curr+1,0,dp);
               noflip= solve(s,curr+1,1,dp);
            }else{                          //prev==1
              noflip= solve(s,curr+1,1,dp);
            }
      }else{                                //curr==0
          if(prev==1){
            flip=1+solve(s,curr+1,1,dp);
          }else{                            //prev==0
                flip=1+ solve(s,curr+1,1,dp);
                noflip= solve(s,curr+1,0,dp);
          }
      }
      return dp[curr][prev]=Math.min(flip,noflip);
    }
    public int minFlipsMonoIncr(String s) {
        int dp[][] = new int[s.length()][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(s,0,0,dp);
    }
}