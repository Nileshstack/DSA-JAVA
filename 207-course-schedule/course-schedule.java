class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[numCourses];
        
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;   
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(degree[i] == 0){
                que.offer(i);
            }
        }
        
        int c = 0;
        while(!que.isEmpty()){
            int curr = que.poll();
            c++;
            for(int next : graph.get(curr)){
                degree[next]--;
                if(degree[next] == 0) que.offer(next);
            }
        }
        
        return c == numCourses;  
    }
}
