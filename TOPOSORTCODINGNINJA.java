import java.util.*; 
import java.io.*; 

public class Solution {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int[] visited = new int[v];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int V = edge.get(1);
            adj.get(u).add(V);
        }
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, s, visited);
            }
        }
        while (!s.isEmpty()) {
            ans.add(s.pop());
        }
        return ans;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, int[] visited) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, adj, s, visited);
            }
        }
        s.push(node); 
    }
}
