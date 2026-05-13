import java.util.*;
class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();               // 문자열을 배열로 변환
        Stack<Character> stack = new Stack<>();     // 스택 생성
        for (int i = 0; i < arr.length; i++) {

        char c = arr[i];                            // 배열 하나씩 비교

         if (c == '(' || c == '{' || c == '[') stack.push(c);   // 여는 괄호면 push

         else {
            if (stack.isEmpty()) return false;                  // 비어있으면 조건만족 X

            char top = stack.pop();                             // 닫는 괄호면 pop - 비교

            if (c == ')' && top != '(') return false;           // 일치하는 괄호가 아니면 조건만족 X
            if (c == '}' && top != '{') return false;
            if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();                                 // 스택이 비어야 조건만족
    }
}