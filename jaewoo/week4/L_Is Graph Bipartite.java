class Solution {

    int[] idx;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        idx = new int[n];

  
        for (int i = 0; i < n; i++) {

            if (idx[i] == 0) {
             
                if (!dfs(graph, i, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int c) {

        idx[node] = c;

        for (int next : graph[node]) {

            if (idx[next] == 0) {
                if (!dfs(graph, next, -c)) {
                    return false;
                }
            }

            else if (idx[next] == c) {
                return false;
            }
        }

        return true;
    }
}