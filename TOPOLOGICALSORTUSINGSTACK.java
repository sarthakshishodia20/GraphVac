class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        Stack<Integer> s=new Stack<>();
        int[] visited=new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==0){
                dfs(i,adj,s,visited);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!s.isEmpty()){
            ans.add(s.pop());
        }
        return ans;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack<Integer> s,int[] visited){
        visited[node]=1;
        for(int it:adj.get(node)){
            if(visited[it]==0){
                dfs(it,adj,s,visited);
            }
        }
        s.push(node);
        return;
    }
}
