import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        if (hour == 0)
            hour = 24;
        
        if (min < 45) {
            hour -= 1;
            min += (60 - 45);
        } else {
            min -= 45;
        }

        if (hour == 24)
            hour = 0;

        System.out.printf("%d %d", hour, min);
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}