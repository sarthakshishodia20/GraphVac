class Solution {
    static class Pair {
        int node;
        int distance;
        public Pair(int node, int dis) {
            this.node = node;
            this.distance = dis;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] visited = new int[V];
        pq.add(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            int distan = pq.peek().distance;
            int nod = pq.peek().node;
            pq.poll();
            
            if (visited[nod] == 1) continue;
            visited[nod] = 1; // Mark the node as visited

            sum += distan;

            for (int i = 0; i < adj.get(nod).size(); i++) {
                int edgeWeight = adj.get(nod).get(i)[1];
                int adjNode = adj.get(nod).get(i)[0];
                if (visited[adjNode] == 0) {
                    pq.add(new Pair(adjNode, edgeWeight));
                }
            }
        }
        return sum;
    }
}
