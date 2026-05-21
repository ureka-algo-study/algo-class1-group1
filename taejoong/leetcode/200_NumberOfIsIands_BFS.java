class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = curr[0] + dr[k];
                            int nc = curr[1] + dc[k];

                            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length
                                    && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0'; 
                                queue.offer(new int[]{nr, nc}); 
                            } // if 2
                        } // for 3
                        
                    } // while
                    
                } // if 1
            } // for 2
        } // for 1
        return count;
    }
}