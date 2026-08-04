class Solution(object):
    def updateBoard(self, board, click):
        m, n = len(board), len(board[0])
        x, y = click

        if board[x][y] == 'M':
            board[x][y] = 'X'
            return board

        directions = [(-1,-1), (-1,0), (-1,1),
                      (0,-1),          (0,1),
                      (1,-1),  (1,0),  (1,1)]

        def dfs(x, y):
            if board[x][y] != 'E':
                return

            mine_count = 0

            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < m and 0 <= ny < n:
                    if board[nx][ny] == 'M':
                        mine_count += 1

            if mine_count > 0:
                board[x][y] = str(mine_count)
                return

            board[x][y] = 'B'

            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < m and 0 <= ny < n:
                    dfs(nx, ny)

        dfs(x, y)

        return board
