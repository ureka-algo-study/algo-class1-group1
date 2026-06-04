class Solution {

    int[][] dirs = {
        {-1,-1}, {-1,0}, {-1,1},
        {0,-1},          {0,1},
        {1,-1},  {1,0},  {1,1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {

        int r = click[0];
        int c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        dfs(board, r, c);

        return board;
    }

    private void dfs(char[][] board, int r, int c) {

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return;

        if (board[r][c] != 'E')
            return;

        int mineCount = 0;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nc < 0 ||
                nr >= board.length || nc >= board[0].length)
                continue;

            if (board[nr][nc] == 'M')
                mineCount++;
        }

        if (mineCount > 0) {
            board[r][c] = (char)(mineCount + '0');
            return;
        }

        board[r][c] = 'B';

        for (int[] dir : dirs) {
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}