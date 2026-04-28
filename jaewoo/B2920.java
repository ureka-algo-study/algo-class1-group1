import java.util.Scanner;

public class B2920 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	int arr[] = new int[8]; //8개의 배열 생성
	for(int i = 0; i < 8; i++) {
		arr[i] = scan.nextInt(); //배열에 숫자 넣기
		}
	
	boolean asc = true; //ascending 판별 boolean
	boolean des = true; //descending 판별 boolean
	
	for(int i = 0; i < 7; i++) {
		if(arr[i]+1!=arr[i+1]) asc = false; //i번째 + 1 <=> i+1 번째가 같지 않으면 ascending 아님
		if(arr[i]-1!=arr[i+1]) des = false; //i번째 - 1 <=> i+1 번째가 같지 않으면 descending 아님
		}
	
	if(asc) System.out.println("ascending");
	else if(des) System.out.println("descending");
	else System.out.println("mixed"); //둘다 아니면 mixed 출력
	}//main
}//class