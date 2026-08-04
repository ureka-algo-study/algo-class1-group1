from collections import deque

class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        n = len(grid)

        if grid[0][0] == 1 or grid[n-1][n-1] == 1:
            return -1

        q = deque([(0, 0, 1)])

        directions = [
            (-1,-1), (-1,0), (-1,1),
            (0,-1),          (0,1),
            (1,-1),  (1,0),  (1,1)
        ]

        grid[0][0] = 1

        while q:
            x, y, dist = q.popleft()

            if x == n-1 and y == n-1:
                return dist

            for dx, dy in directions:
                nx = x + dx
                ny = y + dy

                if (
                    0 <= nx < n and
                    0 <= ny < n and
                    grid[nx][ny] == 0
                ):
                    grid[nx][ny] = 1
                    q.append((nx, ny, dist + 1))

        return -1
