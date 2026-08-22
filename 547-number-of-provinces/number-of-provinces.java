class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[],int node){
        visited[node]=true;
        for(int v : adj.get(node)){
            if(!visited[v]){
                dfs(adj,visited,v);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        boolean visited[]= new boolean[isConnected.length];
        int n= isConnected.length;
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i); // undirected
                }
            }
        }
        int p=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(adj,visited,i);
                p++;
            }
        } 
        return p;
    }
}