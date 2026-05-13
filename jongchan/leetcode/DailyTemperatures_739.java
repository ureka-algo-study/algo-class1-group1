class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!deq.isEmpty() && temperatures[deq.peek()] < temperatures[i]) {
                int ex = deq.pop();
                res[ex] = i - ex;
            }
            deq.push(i);
        }

        return res;
    }
}