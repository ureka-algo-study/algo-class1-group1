import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                pq.offer(matrix[r][c]);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}
