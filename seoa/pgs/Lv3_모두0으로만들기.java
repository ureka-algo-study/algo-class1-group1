package seoa.pgs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lv3_모두0으로만들기 {
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        int n = a.length;
        long[] weight = new long[n];
        int[] degree = new int[n];
        
        for (int i = 0; i < n; i++) {
            sum += a[i];
            weight[i] = a[i];
        }
        
        if (sum != 0) {
            return -1;
        }
        
        if (n == 1) {
            return 0;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        long answer = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            degree[current]--;

            for (int next : graph.get(current)) {
                if (degree[next] > 0) {
                    degree[next]--;
                    weight[next] += weight[current];
                    answer += Math.abs(weight[current]);
                    
                    if (degree[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }

        return answer;
    }
}
