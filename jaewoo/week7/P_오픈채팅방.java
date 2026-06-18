import java.util.*;

class Solution {
    public String[] solution(String[] record) {

  
        Map<String, String> nickname = new HashMap<>();
        for (String line : record) {
            String[] token = line.split(" ");
            if (token[0].equals("Enter") || token[0].equals("Change")) {
                nickname.put(token[1], token[2]);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String line : record) {
            String[] token = line.split(" ");
            if (token[0].equals("Enter")) {
                answer.add(nickname.get(token[1]) + "님이 들어왔습니다.");
            } else if (token[0].equals("Leave")) {
                answer.add(nickname.get(token[1]) + "님이 나갔습니다.");
            }

        }

        return answer.toArray(new String[0]);
    }
}
