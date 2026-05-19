class Solution {
    int dx[] = {-1, 1, 0, 0}; // 방향 탐색용
    int dy[] = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        boolean visit [][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visit[i][j]){  // 1을 발견했고, 방문하지 않은곳이면
                    count++;                          // count 
                    dfs(grid, i, j, visit);           // dfs

                }//if
                
            }//forj
            
        }//fori
    return count;
    }//numIslands

    public void dfs(char[][] grid, int i, int j, boolean[][] visit){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visit[i][j]) return; // grid 범위 벗어나는 경우, 방문 한 경우
        else{
            visit [i][j] = true; // 방문처리

            int nexti = 0;  
            int nextj = 0;  
            for(int k = 0; k < 4;  k++){ //4 방향 탐색
            nexti = i + dx[k]; 
            nextj = j + dy[k];

            dfs(grid, nexti, nextj, visit); // dfs
            }//for
        }//else
    }//dfs   
}//class
        