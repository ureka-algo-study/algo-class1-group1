package seoa.LeetCode;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_1514_PathwithMaximumProbability {    
    static class Edge {
        int node;
        double prob;
        
        public Edge(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            
            graph.get(u).add(new Edge(v, prob));
            graph.get(v).add(new Edge(u, prob));
        }
        
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Edge(start, 1.0));
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            
            if (current.node == end) {
                return current.prob;
            }
            
            if (current.prob < maxProb[current.node]) {
                continue;
            }
            
            for (Edge next : graph.get(current.node)) {
                double nextProb = current.prob * next.prob;
                
                if (nextProb > maxProb[next.node]) {
                    maxProb[next.node] = nextProb;
                    pq.offer(new Edge(next.node, nextProb));
                }
            }
        }
        
        return 0.0;
    }
}
