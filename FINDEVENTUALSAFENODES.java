class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int v : graph[i]) {
                adjRev.get(v).add(i); 
                indegree[i]++;        
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
