class Solution {
    static class Pair {
        int node;
        int distance;
        public Pair(int n, int d) {
            this.node = n;
            this.distance = d;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int nod = current.node;
            int distanc = current.distance;
            if (distanc > dist[nod]) continue; 
            for (Pair neigh : adj.get(nod)) {
                int edgeWeight = neigh.distance;
                int neighbourNode = neigh.node;
                if (edgeWeight + distanc < dist[neighbourNode]) {
                    dist[neighbourNode] = edgeWeight + distanc;
                    pq.add(new Pair(neighbourNode, dist[neighbourNode]));
                    ways[neighbourNode] = ways[nod]; 
                } else if (edgeWeight + distanc == dist[neighbourNode]) {
                    ways[neighbourNode] = (ways[neighbourNode] + ways[nod]) % 1_000_000_007;
                }
            }
        }
        return ways[n - 1];
    }
}
