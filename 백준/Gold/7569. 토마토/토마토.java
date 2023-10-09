import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[h][n][m];

        for (int height = 0; height < h; height++) {
            for (int row = 0; row < n; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < m; col++) {
                    tomato[height][row][col] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(bfs(tomato, h, n, m));
    }

    public static int bfs(int[][][] tomato, int h, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        for (int height = 0; height < h; height++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (tomato[height][row][col] == 1) {
                        queue.add(new int[] { height, row, col });
                    }
                }
            }
        }

        int[] dh = { -1, 1, 0, 0, 0, 0 };
        int[] dx = { 0, 0, -1, 1, 0, 0 };
        int[] dy = { 0, 0, 0, 0, -1, 1 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int ch = current[0], cx = current[1], cy = current[2];

                for (int dir = 0; dir < 6; dir++) {
                    int nh = ch + dh[dir], nx = cx + dx[dir], ny = cy + dy[dir];

                    if (nh >= 0 && nh < h && nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (tomato[nh][nx][ny] == 0) {
                            tomato[nh][nx][ny] = 1;
                            queue.add(new int[] { nh, nx, ny });
                        }
                    }
                }
            }
            time++;
        }
        // 익히지 않은 토마토가 존재할 경우
        for (int height = 0; height < h; height++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (tomato[height][row][col] == 0) {
                        return -1;
                    }
                }
            }
        }

        return time - 1;
    }
}
