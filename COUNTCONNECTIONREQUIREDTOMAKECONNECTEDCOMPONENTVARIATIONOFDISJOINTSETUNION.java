class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        DisjointSet ds=new DisjointSet(n);
        int extraEdge=0;
        for(int[] conn:connections){
            int u=conn[0];
            int v=conn[1];
            if(ds.findUParent(u)==ds.findUParent(v)){
                extraEdge++;
            }
            else{
                ds.unionByRank(u,v);
            }
        }
        int countConnected=0;
        for(int i=0;i<n;i++)
        {
            if(ds.parent[i]==i){
                countConnected++;
            }
        }
        return (extraEdge>=countConnected-1)?countConnected-1:-1;
    }
}
class DisjointSet{
    int[] rank;
    int[] parent;
    public DisjointSet(int n){
        rank=new int[n];
        parent=new int[n];
        for(int i=0;i<n;i++){
            rank[i]=0;
            parent[i]=i;
        }
    }
    public int findUParent(int node){
        if(node==parent[node]){
            return node;
        }
        return parent[node]=findUParent(parent[node]);
    }
    public void unionByRank(int u,int v){
        int ulp_u=findUParent(u);
        int ulp_v=findUParent(v);
        if(ulp_u==ulp_v){
            return;
        }
        if(rank[ulp_u]<rank[ulp_v]){
            parent[ulp_u]=ulp_v;
        }
        else if(rank[ulp_u]>rank[ulp_v]){
            parent[ulp_v]=ulp_u;
        }
        else{
            parent[ulp_v]=ulp_u;
            rank[ulp_u]++;
        }
    }
}
