import java.util.Scanner;

public class Main {
    public static char[][] board;
    public static int R, C;
    public static boolean[] visited = new boolean[26]; // 'A' ~ 'Z'
    public static int answer = 0;

    public static void main(String[] args) {
        // 같은 알파벳 칸을 지나갈 수 없다.
        // (0,0)에서 출발
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        // 범위 밖
        if (!isRange(x, y)) {
            return;
        }
        // 이미 방문했던 알파벳
        if (!isVisited(x, y)) {
            return;
        }
        visited[board[x][y] - 'A'] = true;
        answer = Math.max(answer, count + 1);
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            dfs(nx, ny, count + 1);
        }
        visited[board[x][y] - 'A'] = false;
    }

    private static boolean isVisited(int nx, int ny) {
        char c = board[nx][ny];
        if (visited[c - 'A']) {
            return false;
        }
        return true;
    }

    private static boolean isRange(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
            return true;
        }
        return false;
    }
}
