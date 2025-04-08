class Solution {
    public static void dfs(int node,int[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list){
        visited[node]=1;
        list.add(node);
        for(Integer it:adj.get(node)){
            if(visited[it]==0){
                dfs(it,visited,adj,list);
            }
        }
    }
    public static boolean completeComponent(ArrayList<Integer> list,ArrayList<ArrayList<Integer>> adj){
        int edges=0;
        for(int node:list){
            edges+=adj.get(node).size();
        }
        edges=edges/2;
        int nodeCount=list.size();
        int expectedEdges=((nodeCount)*(nodeCount-1))/2;//Formula for edge Count in a graph 
        return edges==expectedEdges; // jitne expected hai minimum connection ke liye edges utne hai toh true vrna false;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            ArrayList<Integer> list=new ArrayList<>();
            if(visited[i]==0){
                dfs(i,visited,adj,list);
                if(completeComponent(list,adj)){
                    count++;
                }
            }
        }
        return count;
    }
}
