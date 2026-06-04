import java.util.*;

public class Lv2_게임맵최단거리 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 방문 여부를 기록할 2차원 boolean 배열
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            //BFS의 특성상 처음 도달했을 때가 최단 거리
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 조건 1: 다음 이동할 칸이 맵의 범위(격자)를 벗어나지 않았는지 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 조건 2: 다음 칸이 벽(0)이 아닌 이동할 수 있는 길(1)인지 확인
                    // 조건 3: 아직 방문하지 않은 칸인지 확인
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        
                        queue.offer(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        // 목적지에 도달하지 못했다면 (=상대 팀이 벽으로 막혀 있어 갈 수 없는 경우) -1을 반환
        return -1;
    }
}
