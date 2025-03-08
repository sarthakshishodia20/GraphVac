class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited=new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                if(hasC(i,-1,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasC(int src,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[src]=true;
        for(Integer it:adj.get(src)){
            if(visited[it]==false){
                if(hasC(it,src,adj,visited)){
                    return true;
                }
            }
            else if(it!=parent){
                return true;
            }
        }
        return false;
    }
}
