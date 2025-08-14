class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26); 
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int a = str.charAt(0) - 'a';
                int b = str.charAt(3) - 'a';
                dsu.union(a, b);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int a = str.charAt(0) - 'a';
                int b = str.charAt(3) - 'a';
                if (dsu.findUParent(a) == dsu.findUParent(b)) {
                    return false;
                }
            }
        }
        return true;
    }
}
class DSU {
    int[] rank;
    int[] parent;   
    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int findUParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findUParent(parent[node]);
    }
    public void union(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);   
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}
