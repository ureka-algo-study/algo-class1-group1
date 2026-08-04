import java.util.*;

class Solution {
    static boolean[] isComplete;
    static Deque<Integer> deq;
    static int[] indegree;
    static Map<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        isComplete = new boolean[numCourses];
        indegree = new int[numCourses];
        deq = new ArrayDeque<>();
        map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        int[] order = new int[numCourses];

        int count = 0;
        for (int c = 0; c < numCourses; c++) {
            if (indegree[c] == 0) {
                deq.offer(c);
                isComplete[c] = true;
                order[count] = c;
                count++;
            }
        }

        while (!deq.isEmpty()) {
            int curr = deq.poll();

            if (map.containsKey(curr)) {
                for (int next : map.get(curr)) {
                    indegree[next]--;

                    if (indegree[next] == 0) {
                        isComplete[next] = true;
                        order[count] = next;
                        count++;
                        deq.offer(next);
                    }
                }
            }
        }

        for (boolean v : isComplete) {
            if (v == false) {
                return false;
            }
        }

        return true;
    }

}