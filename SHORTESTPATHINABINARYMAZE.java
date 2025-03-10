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

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] source = {0, 0};
        int[] destination = {n - 1, m - 1};
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 1;
        }
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[source[0]][source[1]] = 1;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        q.add(new Pair(1, source[0], source[1]));
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int dis = current.distance;
            int r = current.row;
            int c = current.col;
            for (int k = 0; k < 8; k++) {
                int nrow = r + dx[k];
                int ncol = c + dy[k];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                    && grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol]) {
                    dist[nrow][ncol] = dis + 1;
                    if (nrow == destination[0] && ncol == destination[1]) {
                        return dis + 1;
                    }
                    q.add(new Pair(dis + 1, nrow, ncol));
                }
            }
        }
        return -1; 
    }
}
