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

// Coding Ninja

public class Solution 
{
    public static int getTotalIslands(int[][] mat) 
	{
        int n=mat.length;
        int m=mat[0].length;
        int[][] visited=new int[n][m];
        int[] dx={-1,-1,0,+1,+1,+1,0,-1};
        int[] dy={0,-1,-1,-1,0,+1,+1,+1};
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++)
            {
                if(visited[i][j]==0 && mat[i][j]==1){
                    dfs(i,j,visited,mat,dx,dy);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int row,int col,int[][] visited,int[][] matrix,int[] dx,int[] dy){
        visited[row][col]=1;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int k=0;k<8;k++){
            int nrow=dx[k]+row;
            int ncol=dy[k]+col;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && matrix[nrow][ncol]==1){
                dfs(nrow,ncol,visited,matrix,dx,dy);
            }
        }
        return;
    }
}
