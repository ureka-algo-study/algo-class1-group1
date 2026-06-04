import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2]; 
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[k] = 0;                         

        boolean[] visited = new boolean[n + 1]; 

        for (int count = 0; count < n; count++) {
            
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }

            if (u == -1) break;
            visited[u] = true;

            for (int v = 1; v <= n; v++) {
                if (graph[u][v] != -1 && dist[u] != Integer.MAX_VALUE) {    
                    if (dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // 유희준 왔다감.
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; 
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }
        return maxDelay;
    }
}
