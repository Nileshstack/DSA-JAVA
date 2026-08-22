class Solution {
    public boolean canFinish(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[]= new int[V];
        
        for(int edge[] : edges){
            int u= edge[0];
            int v= edge[1];
            //directed isliye dono direction me add karo 
            adj.get(u).add(v);
            
            indegree[v]++;
        }
        int c=0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                que.offer(i);
                c++;
            }
        }
        
        while(!que.isEmpty()){
            int u= que.poll();
            for(int nei: adj.get(u)){
                indegree[nei]--;
                if(indegree[nei]==0){
                que.offer(nei);
                c++;
                }
            }
        }
        return c==V?true:false;
    }
}