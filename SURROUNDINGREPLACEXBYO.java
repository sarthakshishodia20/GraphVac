public class Solution {
    public static void dfs(int row, int col, int[][] visited, int[] dx, int[] dy, int n, int m, char[][] matrix) {
        visited[row][col] = 1;
        for (int k = 0; k < 4; k++) {
            int nrow = row + dx[k];
            int ncol = col + dy[k];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && matrix[nrow][ncol] == 'O') {
                dfs(nrow, ncol, visited, dx, dy, n, m, matrix);
            }
        }
    }

    public static void replaceOWithX(char matrix[][]) {
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] visited = new int[n][m];

        for (int i = 0; i < m; i++) {
            if (visited[0][i] == 0 && matrix[0][i] == 'O') {
                dfs(0, i, visited, dx, dy, n, m, matrix);
            }
            if (visited[n - 1][i] == 0 && matrix[n - 1][i] == 'O') {
                dfs(n - 1, i, visited, dx, dy, n, m, matrix);
            }
        }
        for (int j = 0; j < n; j++) {
            if (visited[j][0] == 0 && matrix[j][0] == 'O') {
                dfs(j, 0, visited, dx, dy, n, m, matrix);
            }
            if (visited[j][m - 1] == 0 && matrix[j][m - 1] == 'O') {
                dfs(j, m - 1, visited, dx, dy, n, m, matrix);
            }
        }

        // Convert unvisited 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == 'O') {
                    matrix[i][j] = 'X';
                }
            }
        }
    }
}
