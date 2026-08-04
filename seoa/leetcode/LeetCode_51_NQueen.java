package seoa.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_NQueen {
	int[] board;
	List<List<String>> res;

	int n;
	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		board = new int[n];
		res = new ArrayList<List<String>>();
		
		chess(0);
		
		return res;
	}
	
	private void chess(int idx) {
		//idx가 0보다 클 때 검사한다 (0인 경우 1개만 놓으면 되므로 검사하지 않아도 됨)
		//0에서부터 놓기 시작하므로, 이전까지의 놓은 위치를 확인한다
		if(idx > 0 && !check(idx-1)) return;

		if(idx >= n) {
			//0부터 놓기 때문에 index가 n-1를 지나면 퀸의 위치가 확정
			//완성된 경우 위치 좌표를 출력
			print(board);
			return;
		} // 재귀 탈출

		for (int col = 0; col < n; col++) {
			board[idx] = col;
			chess(idx + 1);
		}
	}
	
	private boolean check (int i) {
		//서로 유효거리에 있는지 확인
		for (int j = 0; j < i; j++) {
			//인덱스가 행 번호이므로 별도의 검사를 거치지 않음
			if (board[j] == board[i]) {
				//다른 행끼리 열 번호가 같은 경우
				return false;
			}
			if (Math.abs(j-i) == Math.abs(board[j]-board[i])) {
				//행끼리 차이와 열끼리 차이를 비교해 대각선에 있는지 확인
				return false;
			}
		}
		return true;
	}
	
	private void print(int[] board) {
		List<String> strList = new ArrayList<>();
		String str = new String();
		for (int i = 0; i < n; i++) { //행
			for (int j = 0; j < n; j++) {
				if (board[i] == j) {
					str += "Q";
					continue;
				}
				str+=".";
			}
			strList.add(str);
			str = new String();
		}
		res.add(new ArrayList<>(strList));
	}
}
