class Solution {
    public boolean isValid(String s) {
        Deque<Character> deq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    deq.push(')');
                    break;
                case '[':
                    deq.push(']');
                    break;
                case '{':
                    deq.push('}');
                    break;
                default:
                    if (!deq.isEmpty() && deq.peek() == c) {
                        deq.pop();
                    } else {
                        return false;
                    }
            }
        }

        return deq.isEmpty();
    }
}