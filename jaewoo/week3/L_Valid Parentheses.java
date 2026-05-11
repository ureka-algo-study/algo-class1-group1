import java.util.*;
class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

        char c = arr[i];

         if (c == '(' || c == '{' || c == '[') stack.push(c);

         else {
            if (stack.isEmpty()) return false;

            char top = stack.pop();

            if (c == ')' && top != '(') return false;
            if (c == '}' && top != '{') return false;
            if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}