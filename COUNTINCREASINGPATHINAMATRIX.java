class Solution {
    public int countPaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count+=dfs(i,j,dp,grid,dx,dy);
            }
        }
        return count;
    }
    public static int dfs(int row,int col,int[][] dp,int[][] grid,int[] dx,int[] dy){
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int count=1;
        for(int k=0;k<4;k++){
            int nrow=row+dx[k];
            int ncol=col+dy[k];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]>grid[row][col]){
                count+=dfs(nrow,ncol,dp,grid,dx,dy);
            }
        }
        dp[row][col]=count;
        return count;
    }
}
