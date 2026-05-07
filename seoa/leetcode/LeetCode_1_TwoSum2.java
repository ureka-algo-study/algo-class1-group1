package seoa.LeetCode;

import java.util.HashMap;

public class LeetCode_1_TwoSum2 {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hmap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			//target에서 현재 값을 뺀 결과를 찾기 위해 res에 저장
			int res = target - nums[i];
			
			//put 하기 전에 이미 put된 값이 있는지 확인
			if (hmap.containsKey(res)) {
				//확인 후 nums[i]를 삽입하기 때문에 여기서 값이 있다면 return하면 됨
				return new int[]{hmap.get(res), i};
			}
			hmap.put(nums[i], i);
		}
		//없는 경우
		return new int[]{0, 0};
	}
}
