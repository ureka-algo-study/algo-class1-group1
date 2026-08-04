class Solution(object):
    def solveNQueens(self, n):
        a = [["."] * n for _ in range(n)]
        res = []

        def check(row, col):
            for i in range(row):
                if a[i][col] == "Q":
                    return False

            i, j = row - 1, col - 1
            while i >= 0 and j >= 0:
                if a[i][j] == "Q":
                    return False
                i -= 1
                j -= 1
                
            i, j = row - 1, col + 1
            while i >= 0 and j < n:
                if a[i][j] == "Q":
                    return False
                i -= 1
                j += 1

            return True

        def DFS(row):
            if row == n:
                res.append(["".join(row) for row in a])
                return

            for col in range(n):
                if check(row, col):
                    a[row][col] = "Q"
                    DFS(row + 1)
                    a[row][col] = "."

        DFS(0)
        return res