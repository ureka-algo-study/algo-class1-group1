import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                
                if(maps[nx][ny] == 0)
                    continue;
                
                if(visited[nx][ny])
                    continue;
                
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx,ny});
            }
        }
        if(!visited[n - 1][m - 1])
            return -1;
        
        return dist[n - 1][m - 1];
    }
}