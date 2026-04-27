import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        //45분을 먼저 뺀다.
        M -= 45;
        
        // 45분보다 작으면 60분을 더하고 1시간을 뺀다.
        if(M < 0) {
            M += 60;
            H -= 1;
            
            // 0시보다 작으면 23시가 됨.
            if(H < 0) {
                H = 23;
            }
        }
        System.out.println(H + " " + M);
	}
}