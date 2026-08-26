class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
         for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        int []dist= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[k]=0;
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
           
           int []curr= pq.poll();
           int node=curr[1];
           int distance= curr[0];
           for(int []neigh : graph[node]){
              int neiNode=neigh[0];
              int neiDist=neigh[1];
              if(neiDist+distance<dist[neiNode]){
                dist[neiNode]=neiDist+distance;
                pq.offer(new int[]{neiDist+distance,neiNode});
              }
           } 
        }
           int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
        

}
}