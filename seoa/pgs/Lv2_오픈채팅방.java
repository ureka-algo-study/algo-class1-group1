package seoa.pgs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv2_오픈채팅방 {
	public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        
        for (String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String uid = parts[1];
            
            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = parts[2];
                nicknameMap.put(uid, nickname);
            }
        }
        
        List<String> resultList = new ArrayList<>();
        
        for (String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String uid = parts[1];
            
            if (command.equals("Enter")) {
                resultList.add(nicknameMap.get(uid) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                resultList.add(nicknameMap.get(uid) + "님이 나갔습니다.");
            }
        }
        
        return resultList.toArray(new String[0]);
    }
}
