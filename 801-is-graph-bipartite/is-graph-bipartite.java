class Solution {
    //Using DFS traversing
    public boolean isBipartite(int[][] graph) {
        int arr[]= new int[graph.length];
        Arrays.fill(arr,-1);
        for(int i=0;i<graph.length;i++){
            if(arr[i]==-1){
                if(!color(i,graph,arr,0)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean color(int node,int[][] graph, int arr[],int nodeColour){
        arr[node]=nodeColour;
       for(int neighbour: graph[node]){
        if(arr[node]==arr[neighbour]){
            return false;
        } 
        if(arr[neighbour]==-1){
            if(!color(neighbour,graph,arr,1-nodeColour)){
            return false;
        }
            
        }
       }
       return true;
    }
}