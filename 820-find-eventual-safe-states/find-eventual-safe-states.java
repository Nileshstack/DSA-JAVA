class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adjRev= new ArrayList<>();
        for(int i=0;i<v;i++){
          adjRev.add(new ArrayList<>());
        }
        int []indegree = new int[v];
        for(int i=0;i<v;i++){
            for(int it : graph[i]){
                adjRev.get(it).add(i);//making from 0->1 to 1->0
                indegree[i]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
        //add all node to queue with indegree =0
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int node = que.poll();
            ans.add(node);
            for(int it : adjRev.get(node)){
                indegree[it]--;
                if (indegree[it] == 0) {
                    que.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}