class Solution {
    static class Pair {
        int steps;
        int moves;
        public Pair(int s, int m) {
            steps = s;
            moves = m;
        }
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int idx = 0;
        boolean leftToRight = true;
        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    arr[idx++] = (board[row][col] == -1) ? -1 : board[row][col] - 1;
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    arr[idx++] = (board[row][col] == -1) ? -1 : board[row][col] - 1;
                }
            }
            leftToRight = !leftToRight;
        }
        boolean[] visited = new boolean[n * n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0)); 
        visited[0] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.steps == n * n - 1) {
                return curr.moves;
            }
            for (int dice = 1; dice <= 6; dice++) {
                int next = curr.steps + dice;
                if (next >= n * n) continue;
                if (arr[next] != -1) {
                    next = arr[next];
                }
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Pair(next, curr.moves + 1));
                }
            }
        }
        return -1;
    }
}
