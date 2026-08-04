class Solution(object):
    def numIslands(self, grid):
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]
        n = len(grid)
        a = len(grid[0])
        cnt = 0
        def DFS(x,y):
            grid[x][y]= "0"
            for i in range(4):
                xx = x+dx[i]
                yy = y+dy[i]
                if 0<=xx<n and 0<=yy<a and grid[xx][yy] =="1":
                    DFS(xx,yy)
        for i in range(n):
            for j in range(a):
                if grid[i][j] == "1":
                    DFS(i,j)
                    cnt+=1
        return cnt
