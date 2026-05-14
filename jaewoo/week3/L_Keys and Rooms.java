import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];

   
        visited[0] = true;                        // 0번째 방 입장가능
        stack.push(0);                            // 스택에 넣음

        while (!stack.isEmpty()) { 

            int room = stack.pop();               // ? 번째(현재) 방 탐색용 

            List<Integer> keys = rooms.get(room); // ?번째 방의 키틀을 keys에 기록

            for (int i = 0; i < keys.size(); i++) { 

                int key = keys.get(i);            // 열쇠 하나 꺼내서 검사

                if (!visited[key]) {              // 방문하지 않았으면
                    visited[key] = true;          // 방문처리
                    stack.push(key);              // 스택에 넣음
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {                    // 방문 하지 않은 방 검사
                return false;              
            }
        }

        return true;
    }
}



