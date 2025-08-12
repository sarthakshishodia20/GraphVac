class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited=new int[rooms.size()];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=1;
        while(!q.isEmpty()){
            int currNode=q.poll();
            for(Integer neigh:rooms.get(currNode)){
                if(visited[neigh]==0){
                    visited[neigh]=1;
                    q.add(neigh);
                }
            }
        }
        for(int ele:visited){
            if(ele==0){
                return false;
            }
        }
        return true;
    }
}
