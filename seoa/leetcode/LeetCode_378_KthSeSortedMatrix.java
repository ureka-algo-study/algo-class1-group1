package seoa.LeetCode;

import java.util.*;

public class LeetCode_378_KthSeSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{matrix[i][0], i, 0});
        }
        
        for (int i = 0; i < k - 1; i++) {
            int[] current = pQueue.poll();
            int r = current[1];
            int c = current[2];
            
            if (c + 1 < n) {
                pQueue.offer(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }
        
        return pQueue.poll()[0];
    }
}