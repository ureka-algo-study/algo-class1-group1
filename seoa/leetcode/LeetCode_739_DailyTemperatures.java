package seoa.LeetCode;

import java.util.Stack;

public class LeetCode_739_DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] answer = new int[temperatures.length];
		
		Stack<Integer> tmpStack = new Stack<>();
		
		for (int i = 0; i<temperatures.length; i++) {
			// 1. 현재 값(temperatures[i])이 스택의 top보다 크면, 단조성이 깨지므로 pop 진행
			// 나보다 높은 기온을 찾기 위해서는 나보다 낮거나 같은 값을 저장해야 하기 때문
			while (!tmpStack.isEmpty() && temperatures[tmpStack.peek()] < temperatures[i]) {
				int index = tmpStack.pop();
				// answer 배열의 index 위치 (stack에서 보관 중이던 낮은 기온의 위치) 에 i와 위치 값의 차를 입력
				answer[index] = i - index;
			}
			// 2. 현재 인덱스를 스택에 push
			tmpStack.push(i);
		}	
		return answer;
	}
}

//class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//		
//		for (int i = 0; i<temperatures.length; i++) {
//			for (int j = i+1; j<temperatures.length; j++) {
//				if (temperatures[i] < temperatures[j]) {
//					temperatures[i] = j-i;
//					break;
//				}
//				temperatures[i] = 0;
//			}
//		}
//		return temperatures;
//	}
//}