class Solution {
     public int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int parentx = find(x, parent);
        int parenty = find(y, parent);

        if (parentx == parenty) return;

        if (rank[parentx] > rank[parenty]) {
            parent[parenty] = parentx;
        } else if (rank[parentx] < rank[parenty]) {
            parent[parentx] = parenty;
        } else {
            parent[parentx] = parenty;
            rank[parenty]++;
        }
    }

    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        } 
        for(int[] edge : edges){
            int n1=edge[0];
            int n2= edge[1];
            union(n1,n2,parent ,rank);
        }
        //Make map to store the component ->size of component
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int p=find(i,parent);           
            if(!map.containsKey(p)){
                map.put(p, 1); 
            } else {
                map.put(p, map.get(p) + 1); 
             }
        }
             long ans = 0;
    long remNode = n;
    for (int size : map.values()) {
        ans += (long) size * (remNode - size);
        remNode -= size;
    }
    
    return ans;
    }
}