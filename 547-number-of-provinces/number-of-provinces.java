class Solution {
    public int findCircleNum(int[][] arr) {
       boolean vis[] = new boolean[arr.length];
       int p=0;
       for(int i=0;i<arr.length;i++){
        if(!vis[i]){
            dfs(arr,vis,i);
            p++;
        }
       } 
       return p;
    }
    public void dfs(int[][] arr, boolean[] vis,int city){
        vis[city]=true;
        for(int j=0;j<arr.length;j++){
            if(arr[city][j] == 1 && !vis[j]) {
                dfs(arr, vis, j);
            }
        }
    }
}