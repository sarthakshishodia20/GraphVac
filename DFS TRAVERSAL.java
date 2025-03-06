class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        int V = adj.size(); 
        boolean[] visited = new boolean[V]; 
        dfs(0, list, visited, adj);
        return list;
    }
    private void dfs(int node, ArrayList<Integer> list, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        list.add(node);
        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, list, visited, adj); 
            }
        }
    }
}
