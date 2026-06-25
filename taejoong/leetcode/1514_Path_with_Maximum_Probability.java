class Solution {

    static class Node {
        int to;
        double prob;

        Node(int to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Node>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            int a =…           
            if(cur.prob < best[cur.to]) {
                continue;
            }

            if(cur.to == end_node) {
                return cur.prob;
            }

            for(Node next : graph[cur.to]) {
                double newProb = cur.prob * next.prob;

                if(newProb > best[next.to]) {
                    best[next.to] = newProb;

                    pq.offer(new Node(next.to, newProb));
                }
            }
        }
        return 0.0;
    }
}