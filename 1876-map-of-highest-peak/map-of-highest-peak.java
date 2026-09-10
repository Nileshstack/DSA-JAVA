class Solution {
    public int[][] highestPeak(int[][] isWater) {
       int n = isWater.length;
       int m = isWater[0].length;
       Queue<int[]> q = new LinkedList<>();
       int [][] direction={{-1,0},{1,0},{0,-1},{0,1}};
       int[][] height= new int[n][m];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(isWater[i][j]==1){
                height[i][j]=0;
                q.offer(new int[]{i,j});
            }
        }
       }
       while(!q.isEmpty()){
        int l= q.size();        
        while(l-->0){
            int [] curr= q.poll();
            int i=curr[0];
            int j= curr[1];
            for (int []dir : direction){
                int curri=i+dir[0];
                int currj=j+dir[1];
                if(curri>=0 && currj>=0 && curri<n && currj<m && isWater[curri][currj]==0){
                    height[curri][currj]=height[i][j]+1;
                    isWater[curri][currj]=1;
                    q.offer(new int[]{curri,currj});
                }
            }
        }
       }
       return height;
    }
}