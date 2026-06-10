class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites) {
            int n = p[0];
            int m = p[1];

            graph[m].add(n);
            indegree[n]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            result[idx++] = cur;

            for(int next : graph[cur]) {
                indegree[next]--;

                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        if(idx != numCourses) {
            return new int[0];
        }
        return result;
    }
}