class Solution {
    static class Pair {
        int node;
        int distance;
        public Pair(int n, int d) {
            this.node = n;
            this.distance = d;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] visited = new int[points.length];
        int sum = 0;
        pq.add(new Pair(0, 0));
        int nodesConnected = 0;
        while (!pq.isEmpty() && nodesConnected < points.length) {
            Pair current = pq.poll();
            int Node = current.node;
            int Distance = current.distance;
            if (visited[Node] == 1) {
                continue;
            }
            visited[Node] = 1;
            sum += Distance;
            nodesConnected++;
            for (int i = 0; i < points.length; i++) {
                if (visited[i] == 0) {
                    int edgeWeight = Math.abs(points[Node][0] - points[i][0]) + Math.abs(points[Node][1] - points[i][1]);
                    pq.add(new Pair(i, edgeWeight));
                }
            }
        }
        return sum;
    }
}
