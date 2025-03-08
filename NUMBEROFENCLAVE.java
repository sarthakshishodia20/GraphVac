class Solution {
    public static void dfs(int row,int col,int[][] visited,int[] dx,int[] dy,int n,int m,int[][] grid){
        visited[row][col]=1;
        for(int k=0;k<4;k++){
            int nrow=row+dx[k];
            int ncol=col+dy[k];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,visited,dx,dy,n,m,grid);
            }
        }
        return;
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int count=0;
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        for(int j=0;j<m;j++){
            if(visited[0][j]==0 && grid[0][j]==1){
                dfs(0,j,visited,dx,dy,n,m,grid);
            }
            if(visited[n-1][j]==0 && grid[n-1][j]==1){
                dfs(n-1,j,visited,dx,dy,n,m,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(visited[i][0]==0 && grid[i][0]==1){
                dfs(i,0,visited,dx,dy,n,m,grid);
            }
            if(visited[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i,m-1,visited,dx,dy,n,m,grid);
            }
        }
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
