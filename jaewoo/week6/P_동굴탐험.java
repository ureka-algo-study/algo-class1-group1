import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {

        // 1. 동굴(트리)을 인접 리스트로 만든다 (양방향)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < path.length; i++) {
            int a = path[i][0];
            int b = path[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // 2. 0번 방에서 BFS로 트리를 펼쳐서 "부모 -> 자식" 방향 그래프를 만든다
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        boolean[] visited = new boolean[n];
        Queue<Integer> bfs = new LinkedList<>();
        bfs.offer(0);
        visited[0] = true;

        while (!bfs.isEmpty()) {
            int cur = bfs.poll();
            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    graph.get(cur).add(next); // cur(부모)를 먼저 가야 next(자식)에 갈 수 있다
                    indegree[next]++;
                    bfs.offer(next);
                }
            }
        }

        // 3. 선행조건 추가: order[i] = [a, b]  ->  a를 먼저, 그 다음 b  (a -> b)
        for (int i = 0; i < order.length; i++) {
            int a = order[i][0];
            int b = order[i][1];
            graph.get(a).add(b);
            indegree[b]++;
        }

        // 4. 위상정렬(BFS): 사이클이 없으면 모든 방을 방문할 수 있다
        Queue<Integer> topo = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                topo.offer(i);
            }
        }

        int count = 0;
        while (!topo.isEmpty()) {
            int cur = topo.poll();
            count++;
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    topo.offer(next);
                }
            }
        }

        // 모든 방을 순서대로 방문 가능 = 방문한 개수가 n개
        return count == n;
    }
}
