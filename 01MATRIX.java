class Solution {
    static class Pair{
        int row;
        int col;
        int dist;
        public Pair(int r,int c,int d){
            this.row=r;
            this.col=c;
            this.dist=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] dist=new int[n][m];
        int[][] visited=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        while(!q.isEmpty()){
            Pair current=q.poll();
            int row=current.row;
            int col=current.col;
            int distance=current.dist;
            dist[row][col]=distance;
            for(int k=0;k<4;k++){
                int nrow=row+dx[k];
                int ncol=col+dy[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 ){
                    q.add(new Pair(nrow,ncol,distance+1));
                    visited[nrow][ncol]=1;
                }
            }
        }
        return dist;
    }
}
