class Solution {
    static class Pair implements Comparable<Pair> {
        int row, col, time;
        public Pair(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
        public int compareTo(Pair other) {
            return this.time - other.time;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        int maxTime = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;
            if (visited[r][c] == 1) continue;
            // visited[r][c] = 1;
            maxTime = Math.max(maxTime, t);
            if (r == n - 1 && c == n - 1) return maxTime;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && visited[nr][nc] == 0) {
                    visited[r][c]=1;
                    pq.add(new Pair(nr, nc, grid[nr][nc]));
                }
            }
        }
        return -1;
    }
}
