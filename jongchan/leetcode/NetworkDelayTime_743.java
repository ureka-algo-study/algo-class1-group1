import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] l : times) {
            graph.get(l[0]).add(new Node(l[1], l[2]));
        }

        return dijkstra(graph, k, n);
    }

    private int dijkstra(Map<Integer, List<Node>> graph, int start, int end) {
        int result = -1;

        int[] distance = new int[graph.size() + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);

        Queue<Node> pqueue = new PriorityQueue<>();
        pqueue.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pqueue.isEmpty()) {
            Node currNode = pqueue.poll();
            if (distance[currNode.vertex] < currNode.distance)
                continue;

            for (Node node : graph.get(currNode.vertex)) {
                int newDist = currNode.distance + node.distance;
                if (newDist < distance[node.vertex]) {
                    distance[node.vertex] = newDist;
                    pqueue.offer(new Node(node.vertex, newDist));
                }
            }
        }

        for (int i = 1; i <= graph.size(); i++) {
            if (distance[i] == INF)
                return -1;
            result = Integer.max(result, distance[i]);
        }

        return result;
    }

    static class Node implements Comparable<Node> {
        private int vertex;
        private int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}