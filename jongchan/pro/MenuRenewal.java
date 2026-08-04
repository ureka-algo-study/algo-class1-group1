import java.util.*;

class Solution {
    static List<String> result;
    static Set<String> courseMenus;

    public String[] solution(String[] orders, int[] course) {
        // 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어간다
        result = new ArrayList<>();
        courseMenus = new HashSet<>();

        // 코스 요리로 만들 메뉴 수 배열을 순회
        for (int amount : course) {
            // 메뉴 수 마다 만든 코스 조합을 갱신
            courseMenus.clear();

            // 고객 주문 메뉴를 순회
            for (String order : orders) {
                // 메뉴로 쪼개기
                char[] menus = order.toCharArray();
                // 메뉴 정렬 -> 중복 조합을 예방하기 위해서
                Arrays.sort(menus);
                // 메뉴의 선택 여부 배열 만들기
                boolean[] picks = new boolean[menus.length];
                // 재귀함수 호출 (메뉴를 조합해 코스를 만든다)
                combineMenus(menus, picks, 0, courseMenus, amount, amount);
            }

            // 제약 조건 중 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보임
            int maxCount = 2;
            List<String> buffer = new ArrayList<>();
            for (String courseMenu : courseMenus) {
                int orderCount = getOrderCount(orders, courseMenu);
                if (orderCount > maxCount) {
                    maxCount = orderCount;
                    buffer.clear();
                }

                if (orderCount >= maxCount) {
                    buffer.add(courseMenu);
                }
            }

            result.addAll(buffer);
        }

        Collections.sort(result);

        return result.toArray(String[]::new);
    }

    void combineMenus(char[] menus, boolean[] picks, int index, Set<String> result, int count, int amount) {
        // 메뉴 목록에서 모두 선택했을 경우 (조합이 완성된 경우)
        if (count == 0) {
            // 메뉴 조합으로 완성된 코스를 반환 배열에 추가한다
            result.add(fromPicksToString(menus, picks));
            return;
        }

        for (int i = index; i < menus.length; i++) {
            picks[i] = true;
            combineMenus(menus, picks, i + 1, result, count - 1, amount);
            picks[i] = false;
        }
    }

    String fromPicksToString(char[] menus, boolean[] picks) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < picks.length; i++) {
            // 선택된 메뉴만 하나의 코스로 조합한다
            if (picks[i]) {
                sb.append(menus[i]);
            }
        }

        return sb.toString();
    }

    // 주문 데이터와 조합된 코스를 비교했을 때, 얼마나 손님에게서 주문된 구성인지?
    int getOrderCount(String[] orders, String course) {
        int match = 0;
        for (String order : orders) {
            if (course.chars().map(order::indexOf).allMatch(c -> c >= 0)) {
                match += 1;
            }
        }
        return match;
    }
}