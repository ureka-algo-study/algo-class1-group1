class Solution {
    static int[] dx = { 0, 1, 0, -1, 1, -1, 1, -1 };
    static int[] dy = { 1, 0, -1, 0, 1, 1, -1, -1 };

    static boolean[][] isVisited;

    static Deque<int[]> deq;

    static int count;

    public int shortestPathBinaryMatrix(int[][] grid) {
        deq = new ArrayDeque<>();
        isVisited = new boolean[grid.length][grid.length];

        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        }

        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        deq.offer(new int[] { 0, 0, 1 });
        isVisited[0][0] = true;

        while (!deq.isEmpty()) {
            int[] currPos = deq.poll();

            int currX = currPos[0];
            int currY = currPos[1];
            int currDist = currPos[2];

            if ((currX == (grid.length - 1)) && (currY == (grid.length - 1))) {
                return currDist;
            }

            for (int i = 0; i < dx.length; i++) {

                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                int[] nextPos = new int[] { nextX, nextY };

                if (isValid(nextX, nextY, grid) && !isVisited[nextX][nextY]) {
                    isVisited[nextX][nextY] = true;
                    deq.offer(new int[] { nextX, nextY, currDist + 1 });
                }
            }

        }

        return -1;
    }

    private boolean isValid(int x, int y, int[][] grid) {
        if ((x >= 0 && x < grid.length)
                && (y >= 0 && y < grid.length)
                && grid[x][y] == 0) {
            return true;
        }
        return false;
    }
}