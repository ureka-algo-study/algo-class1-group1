import java.util.*;

// 투 포인터를 활용한 풀이법
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (o1, o2) -> {
            // 음수 : o1이 앞으로 감 (오름차순)
            // 양수 : o2가 앞으로 감 (내림차순)
            // 0 : 순서 유지
            return o1[0] - o2[0];
        });

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (arr[left][0] + arr[right][0] < target) {
                left = left + 1;
            } else if (arr[left][0] + arr[right][0] > target) {
                right = right - 1;
            } else {
                return new int[] { arr[left][1], arr[right][1] };
            }
        }

        return new int[] { -1, -1 };
    }
}