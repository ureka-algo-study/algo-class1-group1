class LeetCode_529_Minesweeper {
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        
        //클릭한 곳이 지뢰인가?
        if (board[x][y] == 'M') {
            board[x][y] = 'X'; // 지뢰가 터진 상태인 'X'로 변경
            return board;      // 게임 종료
        }
        
        // 빈 공간을 클릭했다면 플러드 필(DFS) 탐색 시작
        dfs(board, x, y);
        
        return board;
    }
    
    private void dfs(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        
        // 주변 8방향의 지뢰 개수 세기
        int mineCount = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 맵 범위를 벗어나지 않는지 확인
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                // 주변에 지뢰가 있는지 카운트
                if (board[nx][ny] == 'M') {
                    mineCount++;
                }
            }
        }
        
        // 지뢰 개수에 따른 재귀 탐색 제어
        if (mineCount > 0) {
            // 지뢰가 1개 이상인 경우 현재 칸을 해당 숫자로 바꾸고, 더 이상 파고들지 않고(재귀 호출 없이) 탐색을 멈춤
            board[x][y] = (char) (mineCount + '0');
        } else {
            // 지뢰가 0개인 경우 현재 칸을 열린 빈칸으로 변경
            board[x][y] = 'B';
            
            // 계속 탐색함
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 범위를 벗어나지 않고 아직 열리지 않은 빈 공간인 경우에만 재귀 호출
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'E') {
                    dfs(board, nx, ny);
                }
            }
        }
    }
}
