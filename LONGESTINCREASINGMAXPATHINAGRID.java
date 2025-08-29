class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int maxPath=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxPath=Math.max(maxPath,dfs(i,j,matrix,dp,dx,dy));
            }
        }
        return maxPath;
    }
    public static int dfs(int row,int col,int[][] matrix,int[][] dp,int[] dx,int[] dy){
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int max=1;
        for(int k=0;k<4;k++){
            int nrow=row+dx[k];
            int ncol=col+dy[k];
            if(nrow>=0 && nrow<matrix.length && ncol>=0 && ncol<matrix[0].length && matrix[nrow][ncol]>matrix[row][col]){
                max=Math.max(max,1+dfs(nrow,ncol,matrix,dp,dx,dy));
            }
        }
        dp[row][col]=max;
        return max;
    }
}
