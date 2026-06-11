import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        // 최대 힙: 항상 "제일 큰 놈"이 맨 위로 올라온다
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 모든 원소를 검열한다
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                pq.offer(matrix[r][c]);

                // 인원이 k명을 초과하면? 제일 큰 놈부터 숙청 🔨
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        // 끝까지 살아남은 k명 중, 제일 큰 놈이 바로 k번째로 작은 값
        return pq.peek();
    }
}
