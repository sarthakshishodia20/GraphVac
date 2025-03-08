import java.util.*;
public class Solution {
	static class Pair{
		int row;
		int col;
		int time;
		public Pair(int r,int c,int t){
			this.row=r;
			this.col=c;
			this.time=t;
		}
	}

	public static int minTimeToRot(int[][] grid, int n, int m) {
		// Write your code here.
		Queue<Pair> q=new LinkedList<>();
		int[][] visited=new int[n][m];
		int countFresh=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]==2){
					q.add(new Pair(i,j,0));

				}
				else{
					visited[i][j]=0;
				}
				if(grid[i][j]==1){
					countFresh++;
				}
			}
		}
		int[] dx={-1,0,+1,0};
		int[] dy={0,+1,0,-1};
		int time=0;
		int count=0;
		while(!q.isEmpty()){
			Pair current=q.poll();
			int row=current.row;
			int col=current.col;
			int tim=current.time;
			time=Math.max(time,tim);
			for(int k=0;k<4;k++){
				int nrow=row+dx[k];
				int ncol=col+dy[k];
				if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
					q.add(new Pair(nrow,ncol,tim+1));
					visited[nrow][ncol]=2;
					count++;
				}
			}
		}
		if(count!=countFresh){
			return -1;
		}
		return time;
	}

}
