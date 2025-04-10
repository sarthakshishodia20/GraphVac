import java.util.*;
public class Solution 
{
	public static int distinctIsland(int [][] arr, int n, int m) 
	{
		//write your code here
		int[][] visited=new int[n][m];
		int[] dx={-1,0,+1,0};
		HashSet<String> ans=new HashSet<>();
		int[] dy={0,+1,0,-1};
		char[] dir={'U','R','D','L'};
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(arr[i][j]==1 && visited[i][j]==0){
					StringBuilder sb=new StringBuilder();
					dfs(i,j,visited,dx,dy,dir,'S',sb,arr);
					ans.add(sb.toString());
				}
			}
		}
		return ans.size();
	}
	public static void dfs(int row,int col,int[][] visited,int[] dx,int[] dy,char[] dir,char move,StringBuilder path,int[][] arr){
		visited[row][col]=1;
		path.append(move);
		for(int k=0;k<4;k++){
			int nrow=row+dx[k];
			int ncol=col+dy[k];
			char newMove=dir[k];
			// path.append(newMove);
			if(nrow>=0 && nrow<visited.length && ncol>=0 && ncol<visited[0].length && arr[nrow][ncol]==1 && visited[nrow][ncol]==0){
				dfs(nrow,ncol,visited,dx,dy,dir,newMove,path,arr);
			}
		}
		// path.deleteCharAt(path.size()-1);
		path.append('B');
	}
}
