import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // 체스판을 만든다.
        char[][] board = new char[n][n];

        // 처음에는 전부 .으로 채운다. 
        // Arrays.fill(배열, 값) = 배열의 모든 값을 같은 값으로 채우는 메서드
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // 백트래킹 시작 0은 첫 번째 행
        backtrack(0, n, board, result);

        return result;
    }

    // row 현재 퀸을 놓을 행, n 체스판 크기, board 현재 체스판 상태, result 정답 리스트
    private void backtrack(int row, int n, char[][] board, List<List<String>> result) {

        // 종료 조건
        if (row == n) {
            result.add(makeBoard(board));
            return;
        }

        // 현재 행에서 모든 열을 하나씩 시도
        for (int col = 0; col < n; col++) {

            // 이 자리에 퀸을 놓아도 되는지 검사
            if (isValid(row, col, n, board)) {
                board[row][col] = 'Q';

                // 다음 행으로 이동
                backtrack(row + 1, n, board, result);
                
                // 방금 놓았던 퀸 제거
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] board) {
        // 같은 열 위쪽 검사
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 왼쪽 위 대각선 검사
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 오른쪽 위 대각선 검사
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // char[][] 상태를 List<String> 형태로 변경
    // char[] row = {'.', 'Q', '.', '.'}; -> ".Q.."
    private List<String> makeBoard(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        return list;
    }
}