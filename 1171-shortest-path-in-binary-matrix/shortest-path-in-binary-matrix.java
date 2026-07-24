class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       int n= grid.length;
       int m = grid[0].length;
       if(n==0 || m==0 || grid[0][0]!=0 || grid[n-1][n-1] == 1){
        return -1;
       } 
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0]=1;
        //store the 4 direction
        int[][] directions = {
        {-1,-1}, {-1,0}, {-1,1},
        {0,-1},           {0,1},
        {1,-1},  {1,0},   {1,1}
       };
        int distance = 1;
        while(!queue.isEmpty()){
            int s= queue.size();
            for(int i=0;i<s;i++){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                if(row==n-1 && col==n-1){
                    return distance;
                }
                for(int[] dir : directions){
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {

                        queue.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 1;
                    }
                    }
            }
            distance++;
        }
        return -1;
    }
}