class Solution {
    int parent[];
    int rank[];
    int n;
    public int find(int i){
        if(parent[i]!=i){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }
    //union by rank
    public void union(int i,int j){
        int rooti=find(i);
        int rootj=find(j);
        if(rooti==rootj) return;
        if (rank[rooti] < rank[rootj]) {
            parent[rooti] = rootj;
        } else if (rank[rooti] > rank[rootj]) {
            parent[rootj] = rooti;
        } else {
            parent[rootj] = rooti;
            rank[rooti]++;
        }
}
    public int removeStones(int[][] stones) {
        n = stones.length;
        parent = new int[n];
        rank = new int[n];

        // Initialize parent and rank
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        // Union stones that share row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                components++;
            }
        }

        // Max stones removed = total stones - number of components
        return n - components;
    }
}