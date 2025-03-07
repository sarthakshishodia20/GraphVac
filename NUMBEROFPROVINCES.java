class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V=isConnected.length;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] visited=new int[isConnected.length];
        int count=0;
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0){
                count++;
                dfs(i,adj,visited);
            }
        }
        return count;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited){
        visited[node]=1;
        for(Integer it:adj.get(node)){
            if(visited[it]==0){
                visited[it]=1;
                dfs(it,adj,visited);
            }
        }
        return;
    }
}
