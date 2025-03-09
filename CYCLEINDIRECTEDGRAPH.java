import java.util.*;

public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    for (ArrayList<Integer> edge : edges) {
      int u = edge.get(0) - 1;
      int v = edge.get(1) - 1;
      adj.get(u).add(v);
    }
    int[] visited = new int[n];
    int[] pathVisited = new int[n];
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0) {
        if (checkForDFS(i, adj, visited, pathVisited)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean checkForDFS(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited) {
    visited[node] = 1;
    pathVisited[node] = 1;
    for (int neighbor : adj.get(node)) {
      if (visited[neighbor] == 0) {
        if (checkForDFS(neighbor, adj, visited, pathVisited)) {
          return true;
        }
      } else if (pathVisited[neighbor] == 1) {
        return true;
      }
    }
    pathVisited[node] = 0; 
    return false;
  }
}
