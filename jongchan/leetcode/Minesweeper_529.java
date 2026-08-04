import java.util.*;

class Solution {
    static int[] dx = { 0, 1, 0, -1, 1, -1, 1, -1 };
    static int[] dy = { 1, 0, -1, 0, 1, -1, -1, 1 };
    static Deque<int[]> queue;

    public char[][] updateBoard(char[][] board, int[] click) {

        int clickX = click[0];
        int clickY = click[1];

        if (board[clickX][clickY] == 'M') {
            board[clickX][clickY] = 'X';
            return board;
        }

        queue = new ArrayDeque<>();
        queue.offer(new int[] { clickX, clickY });

        return bfs(board);
    }

    private char[][] bfs(char[][] grid) {
        while (!queue.isEmpty()) {
            int mineCount = 0;

            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = currX + dx[i], ny = currY + dy[i];

                if (isValid(nx, ny, grid) && grid[nx][ny] == 'M') {
                    mineCount++;
                }
            }

            if (mineCount > 0) {
                grid[currX][currY] = (char) ('0' + mineCount);
                continue;
            }
            grid[currX][currY] = 'B';

            // 현재 격자 기준
            for (int i = 0; i < dx.length; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (isValid(nextX, nextY, grid) && grid[nextX][nextY] == 'E') {
                    grid[nextX][nextY] = 'B';
                    queue.offer(new int[] { nextX, nextY });
                }
            }
        }

        return grid;
    }

    private boolean isValid(int x, int y, char[][] grid) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return true;
        }
        return false;
    }
}