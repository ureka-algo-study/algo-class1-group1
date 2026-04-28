package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2884_알람시계 {
			
	static int H, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		br.close();
		
		if (M < 45) {
			if (H == 0) {
				H = 23;
			} else {
				H--;
			}
			M = (M+60) - 45;
		} else {
			M = M-45;
		}
		
		sb.append(H).append(" ").append(M);
		
		System.out.println(sb);
	} //main
} //class