import java.io.*;
import java.util.*;

public class B1152 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(st.countTokens());
        }
}

        /*
public class B1152 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] arr = s.split(" ");
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
*/
