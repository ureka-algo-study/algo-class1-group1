import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater_42 {
    // 1. stack 활용 풀이법
    public static int trap(int[] height) {
        Deque<Integer> deq = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            while (!deq.isEmpty() && height[i] > height[deq.peek()]) {
                Integer top = deq.pop();

                if (deq.isEmpty())
                    break;

                int distance = i - deq.peek() - 1;

                int waters = Math.min(height[i], height[deq.peek()]) - height[top];

                result += distance * waters;
            }

            deq.push(i);
        }

        return result;
    }
}
