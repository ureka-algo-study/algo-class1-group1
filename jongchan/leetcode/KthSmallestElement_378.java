import java.util.*;

class Solution {
    static Queue<Integer> q;
    static int n;
    static List<Integer> arr;

    public int kthSmallest(int[][] matrix, int k) {
        q = new PriorityQueue<>();
        n = matrix.length;
        arr = new ArrayList<>();

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // q.offer(matrix[i][j]);
        // }
        // }

        // while (!q.isEmpty()) {
        // int v = q.poll();
        // arr.add(v);
        // }

        System.out.println(arr.toString());

        return binarySearch(matrix, k);
    }

    private int binarySearch(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        int res = -1;

        while (low < high) {
            int mid = (low + high) / 2;
            int count = notOfElementBefore(matrix, n, n, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }

        return res;
    }

    private int notOfElementBefore(int[][] matrix, int n, int m, int element) {
        int row = n - 1, col = 0;
        int count = 0;

        while (row >= 0 && col < m) {
            if (matrix[row][col] > element) {
                row--;
            } else {
                count += row + 1;
                col++;
            }
        }

        return count;
    }
}