class Solution {
    public int numIslands(char[][] grid) {
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] visited = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(i, j, visited, n, m, dx, dy, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void dfs(int row, int col, int[][] visited, int n, int m, int[] dx, int[] dy, char[][] grid) {
        visited[row][col] = 1;
        
        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && visited[newRow][newCol] == 0) {
                dfs(newRow, newCol, visited, n, m, dx, dy, grid);
            }
        }
    }
}
