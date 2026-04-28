package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250_ACM호텔 {
	
	//T - 몇 명 찾을 건지
	//H - 몇 층,
	//W - 몇 호의 호텔에서
	//N - 해당 손님의 입장 순서
	static int T, H, W, N;
	static StringBuilder sb = new StringBuilder();
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
				
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
//			//층 수, 방 수, 입장 순서
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int floor = N % H;
			int room = (N / H) + 1;

			if (floor == 0) { // 나머지가 0이면 꼭대기 층
			    floor = H;
			    room = N / H;
			}

			sb.append(floor * 100 + room).append("\n");
		} // for i
		br.close();		
		System.out.println(sb);
	} //main
} //class

/*
2
6 12 10
30 50 72
*/