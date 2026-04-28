import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        list = new int[8];
        for (int i = 0; i < 8; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        if (isAscending(list)) {
            System.out.println("ascending");
        } else if (isDescending(list)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }

    private static boolean isAscending(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if (list[i - 1] > list[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDescending(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if (list[i - 1] < list[i]) {
                return false;
            }
        }

        return true;
    }
}