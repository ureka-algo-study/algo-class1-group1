import java.util.*;

class PCCP2_4_Treasure {
    public int solution(int n, int m, int[][] hole) {
        // 3차원 방문 배열: visited[x][y][신발 사용 여부]
        int[][][] visited = new int[n][m][2];
        
        // 미방문 상태를 -1로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }
        
        // 함정 위치 기록 (빠른 확인을 위해 2차원 boolean 배열 사용)
        boolean[][] isHole = new boolean[n][m];
        for (int[] h : hole) {
            isHole[h[0] - 1][h[1] - 1] = true; // 0-based 인덱스로 변환
        }
        
        // 이동 방향: 상, 하, 좌, 우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        // BFS 큐: int 배열 {x 좌표, y 좌표, 신발 사용 여부}를 담음
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int used = curr[2];
            
            // 도착점에 도달한 경우 (0-based 인덱스이므로 n-1, m-1)
            if (x == n - 1 && y == m - 1) {
                return visited[x][y][used];
            }
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                // [1] 걸어서 이동하는 경우 (1칸 이동)
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위를 벗어나지 않고, 함정이 아니며, 아직 방문하지 않은 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!isHole[nx][ny] && visited[nx][ny][used] == -1) {
                        visited[nx][ny][used] = visited[x][y][used] + 1;
                        queue.offer(new int[]{nx, ny, used});
                    }
                }
                
                // [2] 신비로운 신발을 사용하여 이동하는 경우 (2칸 이동)
                if (used == 0) {
                    int nnx = x + dx[i] * 2;
                    int nny = y + dy[i] * 2;
                    
                    // 범위를 벗어나지 않고, '도착지'가 함정이 아니며, 방문하지 않은 경우
                    // (중간 경유지의 함정 여부는 묻지 않음)
                    if (nnx >= 0 && nnx < n && nny >= 0 && nny < m) {
                        if (!isHole[nnx][nny] && visited[nnx][nny][1] == -1) {
                            visited[nnx][nny][1] = visited[x][y][0] + 1;
                            queue.offer(new int[]{nnx, nny, 1});
                        }
                    }
                }
            }
        }
        
        // 큐를 모두 탐색했음에도 목적지에 도달하지 못했다면
        return -1;
    }
}
