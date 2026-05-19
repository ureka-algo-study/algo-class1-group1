class P_타겟넘버DP {

    public int solution(int[] numbers, int target) {

        int sum = 0;

        for (int num : numbers) {
            sum += num; // numbers 배열의 합 구하기
        }

        if ((sum - target) % 2 != 0) {  // 나누어 떨어지지 않으면 조건 성립 x

            return 0;
        }

        int k = (sum - target) / 2; // 찾아야할 k 값


        int[] dp = new int[k + 1]; //dp 배열 생성

        dp[0] = 1; // 초기값

        for (int num : numbers) {

            
            for (int i = k; i >= num; i--) {

                dp[i] += dp[i - num]; // dp 점화식
            }
        }

        return dp[k]; //최종적으로 K를 만들 수 있는 경우의 수 
    }
}