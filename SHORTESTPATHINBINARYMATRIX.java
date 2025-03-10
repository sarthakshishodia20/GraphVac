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

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[source[0]][source[1]] = 0;
        q.add(new Pair(0, source[0], source[1]));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair tuple = q.poll();
            int distance = tuple.distance;
            int r = tuple.row;
            int c = tuple.col;
            for (int i = 0; i < 4; i++) {
                int nrow = r + dr[i];
                int ncol = c + dc[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                    && grid[nrow][ncol] == 1 && dist[nrow][ncol] > distance + 1) {
                    dist[nrow][ncol] = distance + 1;
                    if (destination[0] == nrow && destination[1] == ncol) {
                        return distance + 1;
                    }
                    q.add(new Pair(distance + 1, nrow, ncol));
                }
            }
        }
        return -1;
    }
}
