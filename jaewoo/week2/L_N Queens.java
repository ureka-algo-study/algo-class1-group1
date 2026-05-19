import java.util.*;

class Solution {

    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

   
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        dfs(0, board, n);

        return answer;
    }

    public void dfs(int row, char[][] board, int n) {


        if (row == n) {

            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }

            answer.add(list);
            return;
        }

        
        for (int col = 0; col < n; col++) {

          
            if (isValid(board, row, col, n)) {

                board[row][col] = 'Q';

                dfs(row + 1, board, n);

                
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, int n) {


        for (int i = 0; i < row; i++) {

            if (board[i][col] == 'Q') {
                return false;
            }
        }

   
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

    
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}