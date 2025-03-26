class Solution {
    public static void dfs(int row,int col,int[][] visited,int[][] grid,int[] dx,int[] dy){
        visited[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int k=0;k<4;k++){
            int nrow=dx[k]+row;
            int ncol=dy[k]+col;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,visited,grid,dx,dy);
            }
        }
    }
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        for(int j=0;j<m;j++){
            if(visited[0][j]==0 && grid[0][j]==1){
                dfs(0,j,visited,grid,dx,dy);
            }
            if(visited[n-1][j]==0 && grid[n-1][j]==1)
            {
                dfs(n-1,j,visited,grid,dx,dy);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i][0]==0 && grid[i][0]==1){
                dfs(i,0,visited,grid,dx,dy);
            }
            if(visited[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i,m-1,visited,grid,dx,dy);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
