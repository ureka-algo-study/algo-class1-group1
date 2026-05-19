import java.util.*;

class P_타겟넘버 {

    public int solution(int[] numbers, int target) {

        Queue<Integer> queue = new LinkedList<>();


        queue.offer(0);

        for (int i = 0; i < numbers.length; i++) {

            int size = queue.size();

            while (size > 0) {

                int current = queue.poll();
                queue.offer(current + numbers[i]);
                queue.offer(current - numbers[i]);
                size--;
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                count++;
            }
        }
        return count;
    }
}

