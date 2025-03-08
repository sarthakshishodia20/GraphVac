class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    count++; 
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || 
            grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, visited, grid);
        dfs(i - 1, j, visited, grid);
        dfs(i, j + 1, visited, grid);
        dfs(i, j - 1, visited, grid);
    }
}

