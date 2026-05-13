class Solution {
    static boolean[] isVisited;
    static Deque<Integer> deq;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        isVisited = new boolean[rooms.size()];
        deq = new ArrayDeque<>();

        // dfs(0, rooms);
        bfs(0, rooms);

        for (boolean isTrue : isVisited) {
            if (!isTrue) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int idx, List<List<Integer>> rooms) {
        isVisited[idx] = true;

        for (int r : rooms.get(idx)) {
            if (!isVisited[r]) {
                dfs(r, rooms);
            }
        }
    }

    private void bfs(int idx, List<List<Integer>> rooms) {
        isVisited[idx] = true;
        deq.offer(idx);

        while (!deq.isEmpty()) {
            int ex = deq.poll();
            for (int next : rooms.get(ex)) {
                if (!isVisited[next]) {
                    deq.offer(next);
                    isVisited[next] = true;
                }
            }
        }

    }
}