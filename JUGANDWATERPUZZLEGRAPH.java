class Solution {
    static class Pair {
        int jug1, jug2;
        public Pair(int j1, int j2) {
            jug1 = j1;
            jug2 = j2;
        }
    }
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Pair(0, 0));
        visited.add("0:0");
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int a = curr.jug1;
            int b = curr.jug2;
            if (a + b == target) return true;
            List<Pair> nextStates = new ArrayList<>();
            nextStates.add(new Pair(x, b));// Fill jug1
            nextStates.add(new Pair(a, y));// Fill jug2
            nextStates.add(new Pair(0, b));// Empty jug1
            nextStates.add(new Pair(a, 0));// Empty jug2
            int pour1 = Math.min(a, y - b);// Pour jug1 → jug2
            nextStates.add(new Pair(a - pour1, b + pour1));
            int pour2 = Math.min(b, x - a);// Pour jug2 → jug1
            nextStates.add(new Pair(a + pour2, b - pour2));
            for (Pair next : nextStates) {
                String key = next.jug1 + ":" + next.jug2;
                if (!visited.contains(key)) {
                    visited.add(key);
                    q.add(next);
                }
            }
        }
        return false;
    }
}
