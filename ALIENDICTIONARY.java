import java.util.*;

public class Solution {
    public static String getAlienLanguage(String[] dictionary, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < dictionary.length - 1; i++) {
            String s1 = dictionary[i];
            String s2 = dictionary[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        List<Integer> list = getTopo(adj, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append((char) (list.get(i) + 'a'));
        }
        return sb.toString();
    }

    public static List<Integer> getTopo(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        // Add nodes with 0 indegree to the queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] dictionary = {"baa", "abcd", "abca", "cab", "cad"};
        int k = 4;
        System.out.println(getAlienLanguage(dictionary, k));
    }
}
