class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int v = graph.length;
       int vis[]= new int[v];
       int pathvis[]= new int[v];
       int check[]= new int [v];
       for(int i=0;i<v;i++){
        if(vis[i]==0){
            dfs(i,graph,vis,pathvis,check);
        }
       }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            if(check[i] == 1) safeNodes.add(i);
        }

        return safeNodes; 
    }
    public boolean dfs(int node, int[][]graph,int vis[],int pathVis[],int check[]){
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;
        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (dfs(it, graph, vis, pathVis, check)) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                return true;
            }
        }
       check[node] = 1;   // mark as safe
        pathVis[node] = 0; // remove from current path
        return false; 
    }
}