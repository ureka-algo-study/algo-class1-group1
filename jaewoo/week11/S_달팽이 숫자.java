package jaewoo.week11;

import java.util.*;

public class S_달팽이 숫자 {
	public static void main(String[] args) {
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for (int i = 0; i < num; i++){
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            int x = 0, y = 0, dir = 0;

            for (int j = 1; j <= n * n; j++){
                arr[x][y] = j;
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx; y = ny;
            }

            for (int r = 0; r < n; r++){
                for (int c = 0; c < n; c++){
                    System.out.print(arr[r][c] + " ");
                }
                System.out.println();
            }
        }
    }
}
