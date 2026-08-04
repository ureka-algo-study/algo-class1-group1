class Solution {
    static boolean[][] isVisited;

    static int m, n;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        isVisited = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    bfs(i, j, grid);
                    count++;
                }

            }
        }

        return count;
    }

    private void bfs(int x, int y, char[][] grid) {
        Deque<int[]> deq = new ArrayDeque<>();

        deq.offer(new int[] { x, y });
        isVisited[x][y] = true;

        while (!deq.isEmpty()) {
            int[] curr = deq.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int i = 0; i < dx.length; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if (isValid(newX, newY, grid) && !isVisited[newX][newY]) {
                    isVisited[newX][newY] = true;
                    deq.offer(new int[] { newX, newY });
                }
            }
        }
    }

    private boolean isValid(int x, int y, char[][] grid) {
        if ((x >= 0 && x < m) && (y >= 0 && y < n) && grid[x][y] != '0') {
            return true;
        }
        return false;
    }
}