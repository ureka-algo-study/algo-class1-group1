class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;

            for (int j = i; j < s.length(); j += i) {
                String cur;
                if (j + i <= s.length()) {
                    cur = s.substring(j, j + i);
                } else {
                    cur = s.substring(j);
                }

                if (cur.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            if (count > 1) sb.append(count);
            sb.append(prev);

            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}