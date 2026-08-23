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

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // handle "a==b"
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                union(u, v, parent, rank);
            }
        }

        // handle "a!=b"
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                int parent1 = find(u, parent);
                int parent2 = find(v, parent);
                if (parent1 == parent2) {
                    return false;
                }
            }
        }

        return true;
    }
}
