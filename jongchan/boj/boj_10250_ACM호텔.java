import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static int H, W, N;
    static List<Integer> results;
    static String[][] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        count = Integer.parseInt(st.nextToken());
        results = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (H >= 1 && H <= 99 && W >= 1 && W <= 99)
                findRoom(H, W, N);

        }

        for (int roomNumber : results) {
            System.out.println(roomNumber);
        }

    }

    private static void findRoom(int h, int w, int n) throws IOException {
        int floor = n % h == 0 ? h : n % h;
        int roomnum = n % h == 0 ? (n / h) : (n / h) + 1;

        int answer = floor * 100 + roomnum;
        results.add(answer);
    }
}