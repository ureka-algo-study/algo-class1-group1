class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int rows = board.length;
        int cols = board[0].length;

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        int x = click[0];
        int y = click[1];        

        if(board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        boolean[][] visited = new boolean[rows][cols];        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            int cnt = 0;

            for(int i = 0; i < 8; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'M') {
                    cnt++;
                  }
            }

            if(cnt > 0) {
                board[row][col] = (char)('0' + cnt);
            } else {
                board[row][col] = 'B';
                
                for(int i = 0; i < 8; i++) {
                    int nr = row + dx[i];
                    int nc = col + dy[i];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && board[nr][nc] == 'E') {
                        q.offer(new int[]{nr,nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
            return board;
    }
}