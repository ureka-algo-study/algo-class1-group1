package seoa.LeetCode;

public class LeetCode_1_TwoSum1 {
    int[] nums, res, answer;
	int target;
	
	public int[] twoSum(int[] nums, int target) {
    	//nums는 받은 숫자 배열, target은 합이 되길 바라는 숫자
		//1+2와 2+1은 동일하므로, 해당 문제도 조합으로 풀 수 있을 것으로 보임
		this.nums = nums;
		this.target = target;
		res = new int[2];
        answer = new int[2];
		
		sum(0, 0);
		
		return answer;
    }
	
	private void sum (int idx, int start) {
		if (idx==2) {
			if ((nums[res[0]]+nums[res[1]]) == target) {
				answer[0] = res[0];
                answer[1] = res[1];
			}
			idx--;
            return;
		}
		
		for (int i = start; i<nums.length; i++) {
			res[idx] = i;
			sum(idx+1, i+1);
			res[idx] = 0;
		}
	}
}
