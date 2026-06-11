import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 1. 그래프(인접 리스트)와 진입차수 배열 준비
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        // prerequisites[i] = [a, b]  ->  b를 먼저 들어야 a를 들을 수 있음 (b -> a)
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course); // prereq 끝나면 course가 풀린다
            indegree[course]++;            // course의 선수과목 개수 +1
        }

        // 2. 진입차수가 0인 과목(선수과목 없는 과목)부터 큐에 넣기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 3. BFS로 위상정렬
        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[idx++] = cur; // 들을 수 있는 과목을 순서에 기록

            for (int next : graph.get(cur)) {
                indegree[next]--;           // cur를 들었으니 next의 선수과목 하나 해결
                if (indegree[next] == 0) {  // 더 이상 선수과목 없으면 큐에 추가
                    queue.offer(next);
                }
            }
        }

        // 4. 모든 과목을 담지 못했다면 사이클 존재 -> 불가능
        if (idx != numCourses) {
            return new int[0];
        }
        return order;
    }
}
