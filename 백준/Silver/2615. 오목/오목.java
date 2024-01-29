import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] board = new int[20][20];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = { 0, 1, 1, -1 };
        int[] dy = { 1, 0, 1, 1 };

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (board[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int prevX = i - dx[k];
                        int prevY = j - dy[k];
                        // 이전 위치에 같은 색의 돌이 있는 경우 스킵
                        if (prevX >= 1 && prevX <= 19 && prevY >= 1 && prevY <= 19 && board[prevX][prevY] == board[i][j]) {
                            continue;
                        }

                        int x = i;
                        int y = j;
                        int count = 1;  // 현재 돌 포함

                        while (true) {
                            x += dx[k];
                            y += dy[k];
                            
                            // 범위 벗어나면 break
                            if (x < 1 || y < 1 || x > 19 || y > 19 || board[x][y] != board[i][j]) {
                                break;
                            }
                            count++;
                        }

                        if (count == 5) {
                            System.out.println(board[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("0");
    }
}
