class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0,i);
            int cnt = 1;
            
            for(int j = i; j < s.length(); j+=i) {
                int end = Math.min(j+i, s.length());
                String cur = s.substring(j, end);
                
                if(prev.equals(cur)) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    cnt = 1; 
                    prev = cur;
                }               
                                              
            }
            
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }                
}