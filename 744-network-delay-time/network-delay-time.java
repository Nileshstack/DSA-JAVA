class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
         for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[] {0,k});

        while(!pq.isEmpty()){

         int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

           

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int weight = nei[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{dist[next], next});
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