package seoa.pgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv2_메뉴리뉴얼 {
	// 조합 결과를 저장할 해시맵 (조합 문자열 : 나온 횟수)
    static Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        // 1. 각 주문(order)을 미리 오름차순 정렬 (XY와 YX를 방지)
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        // 2. 각 코스 요리 개수(course)별로 조합 생성
        for (int len : course) {
            map = new HashMap<>();
            for (String order : orders) {
                if (order.length() >= len) {
                    combination(order, "", 0, len);
                }
            }

            // 3. 해당 코스 길이에서 가장 많이 주문된 횟수 찾기
            if (!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                // 최소 2회 이상 주문된 조합만 정답 후보
                if (max >= 2) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answer.add(key);
                        }
                    }
                }
            }
        }

        // 4. 전체 결과 정렬 (사전 순)
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    // 조합을 만드는 DFS 메서드
    static void combination(String order, String res, int idx, int len) {
        if (res.length() == len) {
            map.put(res, map.getOrDefault(res, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            combination(order, res + order.charAt(i), i + 1, len);
        }
    }
}
