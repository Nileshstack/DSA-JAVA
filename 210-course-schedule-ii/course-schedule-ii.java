class Solution {
    public int[] findOrder(int V, int[][] edges) {

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
            if( indegree[i]==0){
                que.offer(i);
                c++;
            }
        }
        int arr[]= new int[V];
        Stack<Integer> st = new Stack<>();
        while(!que.isEmpty()){
            int u=que.poll();
            st.push(u);
            for(int nei : adj.get(u)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    c++;
                    que.offer(nei);
                }
            }
        }
        int i=0;
        while(!st.isEmpty()){
         arr[i++]=st.pop();
        }
        if(c==V){
            return arr;
        }
        return new int[0] ;
    }
}