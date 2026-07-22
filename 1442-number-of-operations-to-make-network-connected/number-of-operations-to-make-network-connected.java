class Solution {
    public int makeConnected(int n, int[][] connections) {
      if(connections.length < n-1) return -1;
  
      int count =n;
      int[] parent = new int[n];
    for(int i=0;i<n;i++){
        parent[i]=i;//each node is there own parent initially
    }
    for(int [] edge : connections){
        int node1=edge[0];
        int node2=edge[1];

        //finf the root of node1 nad node2
        int root1=find(parent,node1);
        int root2=find(parent,node2);
        //if root are same retturn same edge;
        if(root1!=root2){
           parent[root2] = root1; //unite egde by making root1 as parent of root2
         count--;
        }
       
    }
    return count-1;
    }


    public static int find(int []parent,int node){
        while(node!=parent[node]){
          parent[node]=parent[parent[node]];
          node = parent[node];  
        }
        return node;
    }
}