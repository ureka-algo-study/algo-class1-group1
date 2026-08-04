

import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : num.toCharArray()) {

            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }
            stack.addLast(c);
        }


        while (k > 0) {
            stack.pollLast();
            k--;
        }


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
