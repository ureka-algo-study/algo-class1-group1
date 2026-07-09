// LeetCode 416. Partition Equal Subset Sum
// 담당: 김재우, 이호성
//
// 배열을 두 부분집합으로 나눠서 두 합이 같게 만들 수 있는가?
//
// 핵심 아이디어: 0/1 배낭 (Subset Sum DP)
//   두 부분집합의 합이 같으려면 각 합 = 전체합 / 2 여야 한다.
//     - 전체합이 홀수면 애초에 불가능 → false
//     - target = sum/2 를 "정확히 만들 수 있는가?"의 부분집합 합 문제로 환원
//
//   Coin Change와 다른 점:
//     Coin Change는 같은 동전을 무한히 쓰지만(unbounded),
//     여기선 각 원소를 "한 번만" 쓴다(0/1). 그래서 배낭 루프를
//     "뒤에서 앞으로(target → num)" 돌려야 한 원소가 중복 사용되지 않는다.
//
//   dp[j] = 원소들을 골라서 합 j 를 만들 수 있으면 true
//   점화식: dp[j] = dp[j] || dp[j - num]   (num을 안 쓰거나 / 쓰거나)
//
// 시간 O(n * target), 공간 O(target)

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        // 합이 홀수면 절대 반으로 못 쪼갬
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 아무것도 안 고르면 합 0은 항상 가능

        for (int num : nums) {
            // 뒤에서 앞으로! (앞에서 돌면 같은 num을 여러 번 쓰게 됨)
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
