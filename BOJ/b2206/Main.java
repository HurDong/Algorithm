package b2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static boolean destroy;
    static int n, m, dist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        queue.add(new int[] { 0, 0 });
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) {

            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                } else {

                }
            }
        }
    }

}
