class Solution {
    static class Pair {
        int distance;
        int row;
        int col;

        public Pair(int d, int r, int c) {
            this.distance = d;
            this.row = r;
            this.col = c;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int dis = current.distance;
            int r = current.row;
            int c = current.col;
            if (r == n - 1 && c == m - 1) {
                return dis;
            }
            for (int k = 0; k < 4; k++) {
                int nrow = r + dx[k];
                int ncol = c + dy[k];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nrow][ncol]), dis);
                    if (newEffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Pair(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}
