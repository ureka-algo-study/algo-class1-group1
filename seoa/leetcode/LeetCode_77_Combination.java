package seoa.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_Combination {
	int n=0, k=0;
	int[] nums;
	List<Integer> selNums;
	List<List<Integer>> res;
	
	public List<List<Integer>> combine(int n, int k) {
		//n은 숫자의 총 개수 k는 선택할 숫자의 개수
		//ex. 입력받은 값이 5, 3이면 5C3이 된다
		this.n = n;
		this.k = k;
		selNums = new ArrayList<>();
        res = new ArrayList<>();
        nums = new int[n];
		
		for (int i = 1; i<=n; i++) {
			nums[i-1] = i;
		}
		
		workCombine(0, 0);
		
		return res;
    }
	
	private void workCombine(int idx, int start) {
		
		if (idx == k) {
			res.add(new ArrayList<>(selNums));
			return;
		}
		
		for (int i = start; i < n; i++) {
			//idx 지금 내 위치 start 앞으로 찾아야 하는 위치 (다음에 찾을 위치)
			selNums.add(nums[i]);
			workCombine(idx+1, i+1);
            selNums.remove(selNums.size()-1);
		}
	}
}