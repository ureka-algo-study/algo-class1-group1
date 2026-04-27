import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean ascending = true;
		boolean descending = true;

		for (int i = 1; i <= 8; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 오름차순 확인
			if (num != i) {
				ascending = false;
			}
			// 내림차순 확인
			if (num != 9 - i) {
				descending = false;
			}
		}

		if (ascending) {
			System.out.println("ascending");
		} else if (descending) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}