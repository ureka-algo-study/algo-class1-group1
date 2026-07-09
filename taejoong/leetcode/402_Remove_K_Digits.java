class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : num.toCharArray()) { 
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }

        while(k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            char c = stack.pollFirst();
            if(sb.length() == 0 && c =='0') continue;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}