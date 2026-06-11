package seoa.LeetCode;
import java.util.*;

public class LeetCode_207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int course = pre[0];         // 들어야 할 목표 과목
            int prerequisite = pre[1];   // 먼저 들어야 하는 선수 과목
            
            graph.get(prerequisite).add(course); // b -> a 연결
            indegree[course]++;                  // a의 진입 차수 1 증가
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int completedCount = 0; // 이수를 완료한 과목의 수
        
        while (!queue.isEmpty()) {
            // 큐에서 꺼냈다는 것은 해당 과목을 무사히 이수했음을 의미합니다.
            int current = queue.poll();
            completedCount++;
            
            // 방금 이수한 과목을 선수 과목으로 요구하던 다음 과목들을 확인합니다.
            for (int nextCourse : graph.get(current)) {
                // 선수 과목 하나를 이수했으므로, 다음 과목의 진입 차수를 1 줄여줍니다.
                indegree[nextCourse]--;
                
                // 만약 진입 차수가 0이면 요구되는 선수 과목을 모두 들었으므로 이수할 수 있음
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // 이수한 과목의 수가 전체 과목 수와 같다면 모든 과목을 이수한 것
        return completedCount == numCourses;
    }
}
