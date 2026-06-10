class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] nums : matrix) {
            for(int num : nums) {
                pq.offer(num);
            }
        }

        for(int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.peek();
        
    }
}