import java.util.*;

class Solution {
    static int answer = -1;
    static Deque<int[]> deq;
    static boolean[][] isVisited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        isVisited = new boolean[n][m];
        deq = new ArrayDeque<>();

        bfs(0, 0, 1, maps);

        return answer;
    }

    private void bfs(int x, int y, int l, int[][] maps) {
        deq.offer(new int[] { x, y, l });
        isVisited[x][y] = true;

        while (!deq.isEmpty()) {
            int[] curr = deq.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cl = curr[2];

            if (cx == maps.length - 1 && cy == maps[0].length - 1) {
                answer = cl;
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nl = cl + 1;

                if (isValid(nx, ny, maps) && !isVisited[nx][ny]) {
                    deq.offer(new int[] { nx, ny, nl });
                    isVisited[nx][ny] = true;
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] maps) {
        if (x >= 0 && x < maps.length
                && y >= 0 && y < maps[0].length
                && maps[x][y] != 0) {
            return true;
        }

        return false;
    }
}