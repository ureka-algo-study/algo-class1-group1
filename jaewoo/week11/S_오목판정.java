package jaewoo.week11;
import java.util.*;

public class S_오목판정 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int TC = 0; TC < T; TC++){
            int N = scan.nextInt();
            char[][] board = new char[N][N];
            for (int i = 0; i < N; i++){
                    board[i] = scan.next().toCharArray();
            }    
            if (isomok(board, N)) System.out.println("YES");
            else System.out.println("NO");

        }//T 
    

    

    }

    public static boolean isomok(char[][] board, int N){
        int[] dx = {0, 1, 1, -1};  
        int[] dy = {1, 0, 1, 1};

        for (int x = 0; x < N; x++){
            for (int y = 0; y < N; y++){
                if (board[x][y] != 'o') continue;

                for (int d = 0; d < 4; d++){
                    int cnt = 1;
                    int nr = x + dx[d];
                    int nc = y + dy[d];
                    while (0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] == 'o'){
                        cnt++;
                        if (cnt >= 5) return true;
                        nr += dx[d];
                        nc += dy[d];
                    }
                }
            }
        }
        return false;
    }
}
