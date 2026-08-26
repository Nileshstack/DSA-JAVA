class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       int n= grid.length;
       int m = grid[0].length;
       if(n==0 || m==0 || grid[0][0]!=0 || grid[n-1][n-1] == 1){
        return -1;
       } 
        //store the 4 direction
        int[][] directions = {
        {-1,-1}, {-1,0}, {-1,1},
        {0,-1},           {0,1},
        {1,-1},  {1,0},   {1,1}
       };
       int dist=1;
       grid[0][0]=1;
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0,0}); 
        while(!pq.isEmpty()){
            int N= pq.size();
            while(N>0){
             int []curr= pq.poll();
             int row=curr[0];
             int col=curr[1];
             if(row==n-1 && col==n-1){
                return dist;
             }
             for(int[]dir : directions){
               int newrow=row+dir[0];
               int newcol=col+dir[1];
                if(newrow>=0 && newrow<n &&newcol>=0 && newcol<n && grid[newrow][newcol]==0){
                    grid[newrow][newcol]=1;
                    pq.offer(new int[]{newrow,newcol});
                }
             }
                N--;
            }
            dist++;
            
        }
        return -1;
    }
}