import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 개수
		
		for(int i = 0; i < T; i++) {
			int H = sc.nextInt(); // 층 수
			int W = sc.nextInt(); // 방 수
			int N = sc.nextInt(); // 손님
			
			int floor; // 배정 층
			int room;  // 배정 방
			
			if(N % H == 0) {
				// H = 6, N = 12 -> floor = 6층
				// H = 6, N = 12 -> room = 2호
				floor = H;
				room = N / H;
			} else {
				// H = 6, N = 13 -> floor = 1층
				// H = 6, N = 13 -> room = 3호 
				floor = N % H;
				room = N / H + 1;
			}
			// 방 번호 = 층 * 100 + 방 -> 6 * 100 + 2
			System.out.println(floor * 100 + room);
		}
		sc.close();
	}
}