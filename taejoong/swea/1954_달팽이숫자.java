import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int s = sc.nextInt();
			int[][] arr = new int[s][s];
			int r = 0;
			int c = 0;
			int d = 0;

			for (int i = 1; i <= s * s; i++) {
				arr[r][c] = i;
				int nr = dr[d] + r;
				int nc = dc[d] + c;

				if (nr < 0 || nr >= s || nc < 0 || nc >= s || arr[nr][nc] != 0) {
					d = (d + 1) % 4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				r = nr;
				c = nc;
			}

			sb.append("#").append(test_case).append("\n");
			for (int i = 0; i < s; i++) {
				for (int j = 0; j < s; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		sc.close();
	}
}