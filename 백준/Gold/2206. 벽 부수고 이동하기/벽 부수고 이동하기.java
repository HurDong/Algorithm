import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n, m, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        boolean[][][] visited = new boolean[n][m][2]; // [][][0] : 벽을 부수지 않고 방문 여부 [][][1] : 벽을 부수고 방문 여부
        visited[0][0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        queue.add(new int[] { 0, 0, 1, 0 }); // {x,y,count,벽파괴여부(0이면 파괴가능,1이면 파괴불가)}
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                return cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                } else {
                    if (map[nx][ny] == 0 && !visited[nx][ny][cur[3]]) {
                        visited[nx][ny][cur[3]] = true;
                        queue.add(new int[] { nx, ny, cur[2] + 1, cur[3] });
                    }
                    if (map[nx][ny] == 1 && !visited[nx][ny][1] && cur[3] == 0) {
                        visited[nx][ny][1] = true;
                        queue.add(new int[] { nx, ny, cur[2] + 1, 1 });
                    }
                }
            }
        }
        return -1; // n,m에 도착하지 못한 경우
    }
}
