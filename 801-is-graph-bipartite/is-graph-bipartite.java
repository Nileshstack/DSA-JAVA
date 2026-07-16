class Solution {
    public boolean isBipartite(int[][] graph) {
        int arr[]= new int[graph.length];
        Arrays.fill(arr,-1);
        for(int i=0;i<graph.length;i++){
            if(arr[i]==-1){
                if(!color(i,graph,arr)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean color(int i,int[][] graph, int arr[]){
        Queue<Integer> que = new LinkedList<>();
        que.offer(i);
        arr[i]=0;
        while(!que.isEmpty()){
            int node = que.poll();
            for(int neighbour: graph[node]){
                if(arr[neighbour]==-1){
                   arr[neighbour]=1-arr[node];//oppsite colour to the adjacent node 
                   que.offer(neighbour);
                }else if(arr[neighbour]==arr[node]){
                    return false;
                }
            }
        }
        return true;
    }
}