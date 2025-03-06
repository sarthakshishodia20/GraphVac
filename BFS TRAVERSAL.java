// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[V];
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            list.add(node);
            
            for(Integer it:adj.get(node)){
                if(visited[it]==false){
                    q.add(it);
                    visited[it]=true;
                }
            }
        }
        return list;
    }
}
