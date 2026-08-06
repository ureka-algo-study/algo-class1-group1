import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[] h = new int[N];

			for (int i = 0; i < N; i++) {
				h[i] = sc.nextInt();
			}

			int answer = 0;

			for (int i = 2; i < N - 2; i++) {
				int max = Math.max(Math.max(h[i - 2], h[i - 1]), Math.max(h[i + 1], h[i + 2]));

				if (h[i] > max) {
					answer += h[i] - max;
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
		sc.close();

	}
}