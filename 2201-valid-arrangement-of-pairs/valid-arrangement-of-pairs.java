class Solution {
    public void dfs(Map<Integer, List<Integer>> adj,int start,Stack<Integer> st){

    }
    public int[][] validArrangement(int[][] pairs) {
       Map<Integer, List<Integer>> adj = new HashMap<>();
       Map<Integer,Integer> indegree = new HashMap<>();
       Map<Integer,Integer> outdegree = new HashMap<>();
        for (int[] pair : pairs) {
            // agar key pehle se exist nahi karti
            if (!adj.containsKey(pair[0])) {
                adj.put(pair[0], new ArrayList<>());
            }
            // ab list me value add kar do
            adj.get(pair[0]).add(pair[1]);

            indegree.put(pair[1], indegree.getOrDefault(pair[1], 0) + 1);
            outdegree.put(pair[0], outdegree.getOrDefault(pair[0], 0) + 1);
        }
        //find the starting node
        int stNode=pairs[0][0];
       for(int key : outdegree.keySet()){
        if (outdegree.get(key) - indegree.getOrDefault(key, 0) == 1) {
        stNode = key;
        break;
    }
   }
        Stack<Integer> st= new Stack<>();
        ArrayList<Integer> euler= new ArrayList<>();
        st.push(stNode);
        while(!st.isEmpty()){
            int curr = st.peek();
            if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
            int next = adj.get(curr).remove(adj.get(curr).size() - 1);
            st.push(next);
        } else {
            euler.add(st.pop());
        }

        }
        int [][] ans = new int[pairs.length][2];
        Collections.reverse(euler);
        for (int i = 0; i < euler.size() - 1; i++) {
            ans[i] = new int[]{euler.get(i), euler.get(i + 1)};
        }
        return ans;
    }
}