package seoa.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_46_Permutation {
	static boolean[] isSelected;
	static List<Integer> selNums = new ArrayList<>();
	static List<List<Integer>> res;
	
	public List<List<Integer>> permute(int[] nums) {
		
        res = new ArrayList<>();
		isSelected = new boolean[nums.length];
		workPermute(0, nums.length, nums);
		
		
		return res;
    }
	
	private void workPermute(int idx, int end, int[] nums) {
		
		if (idx>=end) {
			res.add(new ArrayList<>(selNums));
			return;
		}
		
		for (int i = 0; i < end; i++) {
			if (isSelected[i]) {
				continue;
			}

			selNums.add(nums[i]);
			isSelected[i] = true;
			workPermute(idx+1, end, nums);
			isSelected[i] = false;
			selNums.remove(selNums.size()-1);
		}
	}
}