// import java.util.*;

// class iPair {
//     int first, second;

//     iPair(int first, int second) {
//         this.first = first;
//         this.second = second;
//     }
// }

// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new iPair(src, 0));
        while (!pq.isEmpty()) {
            int distance = pq.peek().second;
            int node = pq.peek().first;
            pq.poll();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighbor = adj.get(node).get(i).first;
                int weight = adj.get(node).get(i).second;
                if (dist[node] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[node] + weight;
                    pq.add(new iPair(neighbor, dist[neighbor]));
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dist) result.add(d);
        return result;
    }
}
