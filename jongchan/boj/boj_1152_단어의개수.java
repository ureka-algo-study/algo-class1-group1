import java.io.*;
import java.util.*;

public class Main {
    public static void solution() throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        while (st.hasMoreTokens()) {

            list.add(st.nextToken());
        }

        System.out.println(list.size());
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}