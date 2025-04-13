class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] incomingEdge=new boolean[n];
        for(List<Integer> edge:edges){
            int from=edge.get(0);
            int to=edge.get(1);
            incomingEdge[to]=true;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!incomingEdge[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}
