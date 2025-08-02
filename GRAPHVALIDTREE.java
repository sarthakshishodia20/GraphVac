class Solution {
    static class DSU {
        int[] rank;
        int[] parent;
        public DSU(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }
        public int findU(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findU(parent[node]);
        }
        public void union(int x, int y) {
            int ulp_x = findU(x);
            int ulp_y = findU(y);
            if (ulp_x == ulp_y) return;
            if (rank[ulp_x] < rank[ulp_y]) {
                parent[ulp_x] = ulp_y;
            } else if (rank[ulp_y] < rank[ulp_x]) {
                parent[ulp_y] = ulp_x;
            } else {
                parent[ulp_y] = ulp_x;
                rank[ulp_x]++;
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dsu.findU(u) == dsu.findU(v)) {
                return false;
            } else {
                dsu.union(u, v);
            }
        }
        return true;
    }
}
