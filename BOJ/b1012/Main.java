package b1012;

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
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] cabbage = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int m1 = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                cabbage[m1][n1] = 1;
            }
            int worms = 0;
            int[] dx = { -1, 0, 0, 1 };
            int[] dy = { 0, 1, -1, 0 };
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    // cabbage는 0으로 visited는 false로 기본값
                    if (cabbage[x][y] == 1 && !visited[x][y]) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[] { x, y });
                        visited[x][y] = true;
                        while (!queue.isEmpty()) {
                            int[] current = queue.poll();
                            int cx = current[0], cy = current[1];
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cx + dx[dir], ny = cy + dy[dir];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (cabbage[nx][ny] == 1 && !visited[nx][ny]) {
                                        queue.add(new int[] { nx, ny });
                                        visited[nx][ny] = true;
                                    }
                                }
                            }
                        }
                        worms++;
                    }
                }
            }
            System.out.println(worms);
        }

    }
}
