import java.util.*;

class Solution {
    static List<String> result;
    static Set<String> courseMenus;

    public String[] solution(String[] orders, int[] course) {
        // 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어간다
        result = new ArrayList<>();
        courseMenus = new HashSet<>();

        for (int amount : course) {
            courseMenus.clear();
            for (String order : orders) {
                char[] menus = order.toCharArray();
                Arrays.sort(menus);
                boolean[] picks = new boolean[menus.length];
                combineMenus(menus, picks, 0, courseMenus, amount, amount);
            }

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
        if (count == 0) {
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
            if (picks[i]) {
                sb.append(menus[i]);
            }
        }

        return sb.toString();
    }

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