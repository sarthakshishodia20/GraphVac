class Solution {
    static class Pair {
        int node, weight;
        public Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        // Priority queue for Dijkstra
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source node initialization
        dist[1] = 0;
        parent[1] = -1;
        pq.add(new Pair(1, 0));

        // Dijkstra’s Algorithm
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int edgeWeight = neighbor.weight;

                if (weight + edgeWeight < dist[nextNode]) {
                    dist[nextNode] = weight + edgeWeight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                    parent[nextNode] = node;
                }
            }
        }

        // If destination is unreachable
        if (dist[n] == Integer.MAX_VALUE) {
            return Collections.singletonList(-1);
        }

        // Reconstructing path
        List<Integer> path = new ArrayList<>();
        int currNode = n;
        while (currNode != -1) {
            path.add(currNode);
            currNode = parent[currNode];
        }

        Collections.reverse(path);
        path.add(0, dist[n]); 
        return path;
    }
}
