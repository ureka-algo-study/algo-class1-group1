package seoa.LeetCode;

import java.util.Stack;

public class LeetCode_42_TrappingRainWater {
	public int trap(int[] height) {
	    int n = height.length;
	    if (n == 0) return 0;
	    
	    Stack<Integer> stack = new Stack<>();
	    int water = 0;
	    
	    for (int i = 0; i < n; i++) {
	        // 현재 높이가 스택 최상단 높이보다 크면 물을 채울 기회
	        while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
	            int bottom = stack.pop();
	            
	            // 왼쪽 벽이 없으면 물이 고일 수 없음
	            if (stack.isEmpty()) break;
	            
	            int left = stack.peek();
	            int width = i - left - 1;
	            int wheight = Math.min(height[i], height[left]) - height[bottom];
	            
	            water += width * wheight;
	        }
	        stack.push(i); // 인덱스 저장
	    }
	    return water;
	}
}