import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] l : road) {
            graph.get(l[0]).add(new Node(l[1], l[2]));
            graph.get(l[1]).add(new Node(l[0], l[2]));
        }

        int[] result = dijkstra(graph, 1);

        System.out.println(Arrays.toString(result));

        return Arrays.stream(result).filter(x -> x <= K).toArray().length;
    }

    private int[] dijkstra(Map<Integer, List<Node>> graph, int start) {
        final int INF = Integer.MAX_VALUE;
        int[] distance = new int[graph.size() + 1];
        Arrays.fill(distance, INF);

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (distance[current.next] < current.distance)
                continue;

            for (Node node : graph.get(current.next)) {
                int newDist = current.distance + node.distance;
                if (newDist < distance[node.next]) {
                    distance[node.next] = newDist;
                    pq.offer(new Node(node.next, newDist));
                }
            }
        }

        return distance;
    }

    static class Node implements Comparable<Node> {
        private int next;
        private int distance;

        public Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }
}