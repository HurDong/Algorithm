import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] map;
    static boolean[][] outside;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        // 네 변중 두 변 이상이 외부와 접촉시 해당 치즈는 1시간 후 사라짐
        // 단, 치즈 안에 있으면서 두 변 이상 외부 접촉 치즈는 사라지지 않음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        // 치즈가 없어질 때까지
        while (!noCheese()) {
            visited = new boolean[n][m];
            outside = new boolean[n][m];
            // 핵심은 치즈 안에 있는 치즈를 찾는 것이다.
            // 치즈 내부에 있는 공기는 외부 공기라고 치지 않는다.
            // 1. 먼저 bfs로 구역을 나누고 외부인지 내부인지 판별.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }
            // 2. 외부 공기와 두 변이상 인접한 치즈만 삭제.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        delete(i, j);
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }

    private static void delete(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isRange(nx, ny)) {
                if (outside[nx][ny]) {
                    count++;
                }
            }
        }
        if (count >= 2) {
            map[x][y] = 0;
        }
    }

    private static boolean noCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    private static void bfs(int x, int y) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] { x, y });
        boolean isOutside = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (isRange(nx, ny)) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[] { nx, ny });
                        list.add(new int[] { nx, ny });
                        // 만약 경계면과 닿았으면 해당 구역은 내부 공기가 아니다.
                        if (nx == 0 || ny == 0 || nx == n - 1 || ny == m - 1) {
                            isOutside = true;
                        }
                    }
                }
            }
        }
        // 외부 공기면
        if (isOutside) {
            for (int[] air : list) {
                outside[air[0]][air[1]] = true;
            }
        }
    }

    private static boolean isRange(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            return true;
        }
        return false;
    }
}
