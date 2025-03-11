class Solution {
    static class Pair {
        int node;
        int weight;

        public Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    static class Tuple {
        int stops;
        int cost;
        int node;

        public Tuple(int s, int c, int n) {
            this.stops = s;
            this.cost = c;
            this.node = n;
        }
    }

    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adj.get(u).add(new Pair(v, wt)); 
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, src));

        while (!q.isEmpty()) {
            Tuple current = q.poll();
            int stopHue = current.stops;
            int costHui = current.cost;
            int nodeHue = current.node;

            if (stopHue > k) {
                continue;
            }

            for (Pair neighbour : adj.get(nodeHue)) {
                int neigh = neighbour.node;
                int weightHua = neighbour.weight;

                if (costHui + weightHua < dist[neigh]) {
                    dist[neigh] = costHui + weightHua;
                    q.add(new Tuple(stopHue + 1, dist[neigh], neigh));
                }
            }
        }

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }
}
