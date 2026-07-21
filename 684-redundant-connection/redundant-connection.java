class Solution {
    public int[] findRedundantConnection(int[][] edges) {
    int[] parent = new int[edges.length+1];
    for(int i=1;i<edges.length;i++){
        parent[i]=i;//each node is there own parent initially
    }
    for(int [] edge : edges){
        int node1=edge[0];
        int node2=edge[1];

        //finf the root of node1 nad node2
        int root1=find(parent,node1);
        int root2=find(parent,node2);
        //if root are same retturn same edge;
        if(root1==root2){
            return edge;
        }
        //unite egde by making root1 as parent of root2
        parent[root2]=root1;
    }
    return new int[0];
    }

    public static int find(int []parent,int node){
        while(node!=parent[node]){
          parent[node]=parent[parent[node]];
          node = parent[node];  
        }
        return node;
    }
}