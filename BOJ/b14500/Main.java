package b14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;
                checkAnotherCase(i, j);
            }
        }
        System.out.println(max);
    }

    // ㅗ 모양에 대한 예외 처리
    private static void checkAnotherCase(int x, int y) {
        // 'ㅗ', 'ㅜ', 'ㅏ', 'ㅓ' 모양에 대한 처리
        if (x >= 1 && y >= 1 && y < m - 1) { // 'ㅗ'
            max = Math.max(max, arr[x][y] + arr[x - 1][y] + arr[x][y - 1] + arr[x][y + 1]);
        }
        if (x >= 1 && x < n - 1 && y < m - 1) { // 'ㅜ'
            max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x - 1][y] + arr[x][y + 1]);
        }
        if (x >= 1 && x < n - 1 && y >= 1) { // 'ㅏ'
            max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x - 1][y] + arr[x][y - 1]);
        }
        if (x < n - 1 && y >= 1 && y < m - 1) { // 'ㅓ'
            max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x][y - 1] + arr[x][y + 1]);
        }
    }

    // ㅗ모양을 제외한 ㅁ ㅡ ㅣ ㄱ ㄴ 모양에 대한 처리
    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(sum, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}
