import java.util.*;

class Solution {

    class Node{
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {

        List<Node>[] graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);

        dist[1] = 0;

        pq.offer(new Node(1,0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.cost > dist[cur.to]) {
                continue;
            }

            for(Node next : graph[cur.to]) {
                if(dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;

                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        int answer = 0;

        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}