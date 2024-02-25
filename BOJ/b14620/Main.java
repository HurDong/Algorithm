package b14620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int n, answer = Integer.MAX_VALUE;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int count, int sum) {
        if (count == 3) {
            answer = Math.min(answer, sum);
            return;
        }
        // 경계면은 무조건 안되므로
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                // 방문하지 않은 곳 주변 4방향 탐색해서 false일때만 dfs
                if (!chkVisited(i, j)) {
                    dfs(count + 1, sum + chkPrice(i, j));
                    backVisited(i, j); //
                }
            }
        }
    }

    // visited[][]를 true로 바꾼 4방향과 자신의 땅 값을 구함.
    private static int chkPrice(int x, int y) {
        int sumPrice = board[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            sumPrice += board[nx][ny];
        }
        return sumPrice;
    }

    // dfs 완료 후 4방향과 자신의 visited[][]를 false로 다시 설정
    private static void backVisited(int x, int y) {
        visited[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = false;
        }
    }

    // 4방향과 자신의 visited[][] 확인 후 모두 false 면 true로 값 변경 후 return false
    private static boolean chkVisited(int x, int y) {
        if (visited[x][y]) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isRange(nx, ny))
                return true;
            else if (visited[nx][ny])
                return true;
        }
        // 모두 visited[][] false이면서 범위 안
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = true;
        }
        visited[x][y] = true;
        return false;
    }

    private static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        }
        return false;
    }
}
