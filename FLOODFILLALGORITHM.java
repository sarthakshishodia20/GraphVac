class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited=new boolean[image.length][image[0].length];
        int[][] arr=new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                arr[i][j]=image[i][j];
            }
        }
        int originalColor=image[sr][sc];
        helper(sr,sc,image,color,arr,originalColor,visited);
        return arr;
    }
    public static void helper(int sr,int sc,int[][] image,int newColor,int[][] arr,int originalColor,boolean[][] visited){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=originalColor || visited[sr][sc]){
            return;
        }
        visited[sr][sc]=true;
        arr[sr][sc]=newColor;
        helper(sr,sc-1,image,newColor,arr,originalColor,visited);
        helper(sr-1,sc,image,newColor,arr,originalColor,visited);
        helper(sr,sc+1,image,newColor,arr,originalColor,visited);
        helper(sr+1,sc,image,newColor,arr,originalColor,visited);
    }
}
