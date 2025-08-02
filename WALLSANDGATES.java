class Solution {
    static class Pair{
        int row;
        int col;
        public Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int[][] ans=new int[grid.length][grid[0].length];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new Pair(i,j));
                }
            }
        }
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int currRow=curr.row;
            int currCol=curr.col;
            for(int k=0;k<4;k++){
                int nrow=currRow+dx[k];
                int ncol=currCol+dy[k];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==Integer.MAX_VALUE){
                    grid[nrow][ncol]=grid[currRow][currCol]+1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        return;
    }
}
