import java.util.*;

public class Solution {

    static class Pair {
        int src;
        int parent;

        public Pair(int src, int parent) {
            this.src = src;
            this.parent = parent;
        }
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // Use n+1 to include 1-based indexing
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1]; // Use size n+1 to match 1-based index

        // Check for cycle in each component
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (checkForCycle(i, -1, adj, visited)) {
                    return "Yes"; // Cycle detected
                }
            }
        }
        return "No"; // No cycle found
    }

    public static boolean checkForCycle(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        visited[src] = true;
        q.add(new Pair(src, parent));

        while (!q.isEmpty()) {
            Pair currNode = q.poll();
            int node = currNode.src;
            int prevParent = currNode.parent;

            for (Integer it : adj.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.add(new Pair(it, node)); // Fix: Use `node` as new parent
                } else if (it != prevParent) { // If visited node is not parent, cycle exists
                    return true;
                }
            }
        }
        return false;
    }
}
