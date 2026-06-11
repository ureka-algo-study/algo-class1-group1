import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            if (graph[a][b] == -1 || c < graph[a][b]) {
                graph[a][b] = c;
                graph[b][a] = c;
            }
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        boolean[] visited = new boolean[N + 1];

        for (int count = 0; count < N; count++) {

            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }

            if (u == -1) break;
            visited[u] = true;

            for (int v = 1; v <= N; v++) {
                if (graph[u][v] != -1 && dist[u] != Integer.MAX_VALUE) {
                    if (dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}
