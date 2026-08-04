import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    static int max;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        // 갯수로 조합 찾기
        for(int courseSize : course) {
            // 조합이 몇 번 나왔는지 저장하는 용도
            map = new HashMap<>();
            // 현재 길이의 조합 중에서 가장 많이 나온 횟수
            max = 0;
            
            for(String order : orders) {
                // 각 주문을 알파벳 순 정렬
                // "CAB" -> "ABC" 로 만들어서 조합이 항상 같은 키를 갖도록 함
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                
                combination(arr, courseSize, 0, new StringBuilder());
            }
            
            // 최종 정답 고르기
            for(String key : map.keySet()) {
                int count = map.get(key);
                
                if(count >= 2 && count == max) {
                    answer.add(key);
                }
            }
        }
        
        // 알파벳 순 정렬 후 배열로 변환하여 리턴
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    // arr 현재 주문 메뉴 배열, courseSize 만들 조합 길이, start 다음 선택을 시작할 위치, sb 현재까지 만든 조합
    private void combination(char[] arr, int courseSize, int start, StringBuilder sb) {
        
        // 크기별로 조합 생성
        if(sb.length() == courseSize) {
            String menu = sb.toString();
            
            // 해당 조합 map에 저장
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            max = Math.max(max,map.get(menu));
            
            return;
        }
        
        // 백트래킹
        for(int i = start; i < arr.length; i++) {
            sb.append(arr[i]); // 선택    
            
            combination(arr, courseSize, i + 1, sb); // 다음 단계
            
            sb.deleteCharAt(sb.length() - 1); // 원상복구
        }
    }
}