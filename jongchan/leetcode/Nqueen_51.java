import java.util.*;

class Solution {
    static List<List<String>> result;

    static Set<Integer> cols;
    static Set<Integer> diagonalLeft;
    static Set<Integer> diagonalRight;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        cols = new HashSet<>();
        diagonalLeft = new HashSet<>();
        diagonalRight = new HashSet<>();

        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        backtracking(0, board, result);

        return result;
    }

    private void backtracking(int row, char[][] grid, List<List<String>> result) {
        if (row == grid.length) {
            List<String> subs = new ArrayList<>();
            for (char[] chrs : grid) {
                subs.add(new String(chrs));
            }
            result.add(subs);
            return;
        }

        for (int i = 0; i < grid[row].length; i++) {
            if (!cols.contains(i)
                    && !diagonalLeft.contains(row - i)
                    && !diagonalRight.contains(row + i)) {
                grid[row][i] = 'Q';
                cols.add(i);
                diagonalLeft.add(row - i);
                diagonalRight.add(row + i);

                backtracking(row + 1, grid, result);

                grid[row][i] = '.';
                cols.remove(i);
                diagonalLeft.remove(row - i);
                diagonalRight.remove(row + i);
            }
        }
    }
}