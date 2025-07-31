class Solution {
    static class Pair {
        int row, col, height;
        public Pair(int r, int c, int h) {
            this.row = r;
            this.col = c;
            this.height = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;
        int[][] visited = new int[m][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        for (int i = 0; i < m; i++) {
            pq.add(new Pair(i, 0, heightMap[i][0]));
            pq.add(new Pair(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = 1;
            visited[i][n - 1] = 1;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.add(new Pair(0, j, heightMap[0][j]));
            pq.add(new Pair(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = 1;
            visited[m - 1][j] = 1;
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int totalWater = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            for (int dir = 0; dir < 4; dir++) {
                int newRow = current.row + dx[dir];
                int newCol = current.col + dy[dir];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0) {
                    visited[newRow][newCol] = 1;
                    int neighborHeight = heightMap[newRow][newCol];
                    int waterTrapped = Math.max(0, current.height - neighborHeight);
                    totalWater += waterTrapped;
                    pq.add(new Pair(newRow, newCol, Math.max(current.height, neighborHeight)));
                }
            }
        }

        return totalWater;
    }
}
