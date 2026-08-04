class Solution {
    static Map<Integer, List<Integer>> map;
    static int[] degree;
    static Deque<Integer> q;
    static boolean[] isVisited;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        degree = new int[numCourses];
        q = new ArrayDeque<>();
        isVisited = new boolean[numCourses];

        int[] order = new int[numCourses];

        for (int[] edge : prerequisites) {
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }

        int count = 0;
        for (int c = 0; c < numCourses; c++) {
            if (degree[c] == 0) {
                q.offer(c);
                isVisited[c] = true;
                order[count] = c;
                count++;
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (map.containsKey(curr)) {
                for (int next : map.get(curr)) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        isVisited[next] = true;
                        order[count] = next;
                        count++;
                        q.offer(next);
                    }
                }
            }
        }

        for (int d : degree) {
            if (d != 0) {
                return new int[] {};
            }
        }

        return order;
    }
}