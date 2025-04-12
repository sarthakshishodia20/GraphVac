import java.util.*;

public class Solution 
{
    static class Pair implements Comparable<Pair>{
        int node;
        int distance;
        int parent;
        public Pair(int node, int distance, int parent){
            this.node = node;
            this.distance = distance;
            this.parent = parent;
        }
        @Override
        public int compareTo(Pair other){
            return this.distance - other.distance;
        }
    }

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // ? Proper adj list init
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(ArrayList<Integer> lst : g){
            int u = lst.get(0);
            int v = lst.get(1);
            int wt = lst.get(2);
            adj.get(u).add(new Pair(v, wt, u));
            adj.get(v).add(new Pair(u, wt, v));
        }

        boolean[] visited = new boolean[n + 1];
        pq.add(new Pair(1, 0, -1));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int u = current.node;
            int v = current.parent;
            int wt = current.distance;

            if(visited[u]) continue;
            visited[u] = true;

            if(v != -1){
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(v);   // from
                edge.add(u);   // to
                edge.add(wt);  // weight
                result.add(edge);
            }

            for(Pair neigh : adj.get(u)){
                if(!visited[neigh.node]){
                    pq.add(new Pair(neigh.node, neigh.distance, u));
                }
            }
        }

        return result;
    }
}
