class Solution {

    int[][] graph;
    int[] color;

    public boolean isBipartite(int[][] graph) {

        this.graph = graph;

        int n = graph.length;

        color = new int[n];

        // 모든 노드 탐색
        for (int i = 0; i < n; i++) {

            // 아직 방문 안 했으면
            if (color[i] == 0) {

                // DFS 실패하면 false
                if (!dfs(i, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node, int c) {

        // 현재 노드 색칠
        color[node] = c;

        // 연결 노드 탐색
        for (int next : graph[node]) {

            // 아직 방문 안 함
            if (color[next] == 0) {

                // 반대 색으로 DFS
                if (!dfs(next, -c)) {
                    return false;
                }
            }

            // 같은 색이면 실패
            else if (color[next] == c) {
                return false;
            }
        }

        return true;
    }
}
