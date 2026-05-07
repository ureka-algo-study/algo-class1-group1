import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
        }

    private void backtrack(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        // temp가 k 조건에 맞으면 result에 저장
        if(temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // 1부터 시작
        for(int i = start; i <= n; i++) {
            temp.add(i);

            // 중복 불가여서 i + 1로 이전 숫자는 사용하지 않음
            backtrack(i + 1, n, k, temp, result);

            temp.remove(temp.size() - 1);
        }
    }
}