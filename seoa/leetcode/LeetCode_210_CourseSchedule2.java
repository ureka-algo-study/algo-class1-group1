package seoa.LeetCode;
import java.util.*;

public class LeetCode_210_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            
            adjList.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] order = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;
            
            for (int next : adjList.get(current)) {
                inDegree[next]--;
                
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        return index == numCourses ? order : new int[0];
    }
}