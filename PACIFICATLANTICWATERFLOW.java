class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] pacificVisited = new int[n][m];
        int[][] atlanticVisited = new int[n][m];
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};
        for (int i = 0; i < n; i++) {
            dfs(heights, pacificVisited, i, 0, dx, dy);
            dfs(heights, atlanticVisited, i, m - 1, dx, dy);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacificVisited, 0, j, dx, dy);
            dfs(heights, atlanticVisited, n - 1, j, dx, dy);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacificVisited[i][j] == 1 && atlanticVisited[i][j] == 1) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] arr, int[][] visited, int row, int col, int[] dx, int[] dy) {
        visited[row][col] = 1;
        for (int k = 0; k < 4; k++) {
            int nrow = row + dx[k];
            int ncol = col + dy[k];
            if (nrow >= 0 && nrow < arr.length && ncol >= 0 && ncol < arr[0].length &&
                arr[nrow][ncol] >= arr[row][col] && visited[nrow][ncol] == 0) {
                dfs(arr, visited, nrow, ncol, dx, dy);
            }
        }
    }
}
