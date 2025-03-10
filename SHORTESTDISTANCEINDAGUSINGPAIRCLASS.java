
class Solution {
    static class Pair {
        int first;
        int second;
        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] visited, Stack<Integer> s) {
        visited[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first; // Fixed the access to the correct adjacency list
            if (visited[v] == 0) {
                topoSort(v, adj, visited, s);
            }
        }
        s.add(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) { // Fixed initialization to match the number of vertices
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) { // Fixed iteration to go over all edges
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] visited = new int[V];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topoSort(i, adj, visited, s);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!s.isEmpty()) {
            int node = s.pop();
            if (dist[node] != Integer.MAX_VALUE) { // Ensure we process only reachable nodes
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int v = adj.get(node).get(i).first;
                    int wt = adj.get(node).get(i).second;
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
