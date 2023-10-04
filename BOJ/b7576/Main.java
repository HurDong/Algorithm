package b7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] tomato = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(tomato, m, n));
    }

    private static int bfs(int[][] tomato, int m, int n) {
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 1) {
                    queue.add(new int[] { i, j });
                }
            }
        }
        int[] dx = { -1, 0, 0, 1 };
        int[] dy = { 0, -1, 1, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int cx = current[1], cy = current[0];
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cx + dx[dir], ny = cy + dy[dir];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (tomato[ny][nx] == 0) {
                            tomato[ny][nx] = 1;
                            queue.add(new int[] { ny, nx });
                        }
                    }
                }
            }
            time++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) {
                    return -1;
                }
            }
        }
        return time - 1;
    }
}
