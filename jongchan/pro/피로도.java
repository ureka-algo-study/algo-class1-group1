class Solution {
    static int count;
    static boolean[] isVisited;

    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        backtracking(0, k, dungeons);
        return count;
    }

    private void backtracking(int idx, int k, int[][] dungeons) {
        count = Math.max(count, idx);

        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && isValid(i, k, dungeons)) {
                isVisited[i] = true;
                backtracking(idx + 1, k - dungeons[i][1], dungeons);
                isVisited[i] = false;
            }
        }
    }

    private boolean isValid(int idx, int currK, int[][] dungeons) {
        if (currK >= dungeons[idx][0]) {
            return true;
        }

        return false;
    }

}