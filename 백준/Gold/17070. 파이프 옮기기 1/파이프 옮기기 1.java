import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, answer;
    // static int[] dx = { 0, 1, 1 }; // 가로 세로 대각선
    // static int[] dy = { 1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0); // 가로 : 0 세로 : 1 대각선 : 2
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int state) {
        if (x == N - 1 && y == N - 1) {
            answer++;
            return;
        }
        // 가로 이동
        if (state != 1 && y + 1 < N && map[x][y + 1] == 0) {
            dfs(x, y + 1, 0);
        }
        // 세로 이동
        if (state != 0 && x + 1 < N && map[x + 1][y] == 0) {
            dfs(x + 1, y, 1);
        }
        // 대각선 이동
        if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }

}
