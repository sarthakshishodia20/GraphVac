class Solution {
    public int countIslands(int[][] grid, int k) {
        int count=0;
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        int[][] visited=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0 && visited[i][j]==0){
                    int sum=dfs(i,j,dx,dy,grid,visited);
                    if(sum%k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static int dfs(int row,int col,int[] dx,int[] dy,int[][] grid,int[][] visited){
        visited[row][col]=1;
        int sum=grid[row][col];
        for(int k=0;k<4;k++){
            int nrow=row+dx[k];
            int ncol=col+dy[k];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && visited[nrow][ncol]==0 &&grid[nrow][ncol]>0){
                sum+=dfs(nrow,ncol,dx,dy,grid,visited);
            }
        }
        return sum;
    }
}
