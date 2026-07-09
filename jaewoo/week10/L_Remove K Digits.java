// LeetCode 402. Remove K Digits
// 담당: 김태중, 이호성
//
// 숫자 문자열 num에서 자릿수 k개를 지워, 만들 수 있는 "가장 작은 수"를 반환.
//
// 핵심 아이디어: 단조 스택 그리디 (Monotonic Stack + Greedy)
//   가장 작은 수를 만들려면, 앞자리를 최대한 작게 만들어야 한다.
//   왼쪽부터 훑으면서 "앞에 있는 큰 자리"를 뒤의 작은 자리로 밀어내면 됨.
//
//   규칙: 스택 맨 위 숫자가 지금 보는 숫자보다 "크면", 아직 지울 수 있는 한(k>0)
//        그 큰 숫자를 빼버린다. 앞자리가 작아질수록 전체 수가 작아지니까.
//   예) "1432219", k=3
//        1 → [1]
//        4 → [1,4]
//        3 → 4>3 이라 4 제거 → [1,3]  (k=2)
//        2 → 3>2 이라 3 제거 → [1,2]  (k=1)
//        2 → [1,2,2]
//        1 → 2>1 이라 2 제거 → [1,2,1] (k=0)
//        9 → [1,2,1,9]  → "1219"
//
//   마무리 두 가지:
//     - k가 남았으면 (이미 오름차순이라 지울 게 없던 경우) 뒤에서 k개 제거
//     - 맨 앞 '0'들 제거, 다 지워지면 "0"
//
// 시간 O(n), 공간 O(n)

import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : num.toCharArray()) {
            // 스택 위가 지금 숫자보다 크면, 지울 수 있는 만큼 밀어낸다
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }
            stack.addLast(c);
        }

        // 오름차순이라 못 지운 경우 → 뒤에서 남은 k개 제거
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        // 앞자리 0 제거하며 문자열 조립
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char c : stack) {
            if (leadingZero && c == '0') continue;
            leadingZero = false;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
