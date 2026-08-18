class Solution {
    public int orangesRotting(int[][] grid) {
     int n = grid.length;
     int m = grid[0].length;
     Queue<int[]> q = new LinkedList<>();
     int c=0;
     int [][] direction={{-1,0},{1,0},{0,-1},{0,1}};
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==2){
                q.offer(new int[]{i,j});
            }else if(grid[i][j]==1){
                c++;
            }
        }
     } 
      if(c==0) return 0; //all oranges are rotten
       int min =0;
       while(!q.isEmpty()){
        int l= q.size();
        while(l-- >0){
           int []curr= q.poll();
           int i= curr[0];
           int j= curr[1]; 
           for(int dir[] : direction){
            int new_i= i+dir[0];
            int new_j= j+dir[1];
            if(new_i>=0 && new_i<n && new_j>=0 && new_j<m && grid[new_i][new_j]==1){
                grid[new_i][new_j]=2;//rot the orange
                c--;
                q.offer(new int[]{new_i,new_j});
            }
           }
        }
        min++;
       }
       return c==0?(min-1):-1;
    }
}