class Solution {
    public boolean graphColoring(int V, int[][] edges, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1]; 
            adj.get(u).add(w);
            adj.get(w).add(u);
        }

        int[] color = new int[V];
        return dfs(0, adj, color, m, V);
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color, int m, int V) {
        if (node == V) return true; 

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, c, color)) {
                color[node] = c;
                if (dfs(node + 1, adj, color, m, V)) return true;
                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int node, ArrayList<ArrayList<Integer>> adj, int currentColor, int[] color) {
        for (Integer neigh : adj.get(node)) {
            if (color[neigh] == currentColor) return false;
        }
        return true;
    }
}
