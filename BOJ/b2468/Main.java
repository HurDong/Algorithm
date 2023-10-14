package b2468;

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
        int n = Integer.parseInt(st.nextToken());
        int[][] city = new int[n][n];
        int maxDept = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (maxDept < city[i][j])
                    maxDept = city[i][j];
            }
        }
        int maxArea = 1;
        int dept = 1;
        while (dept <= maxDept) {
            int[][] secure = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            int areaCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (city[i][j] <= dept) {
                        secure[i][j] = 0;
                    } else {
                        secure[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (secure[i][j] == 1 && !visited[i][j]) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[] { i, j });
                        visited[i][j] = true;
                        int[] dx = { -1, 1, 0, 0 };
                        int[] dy = { 0, 0, -1, 1 };

                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                    if (!visited[nx][ny] && secure[nx][ny] == 1) {
                                        visited[nx][ny] = true;
                                        queue.add(new int[] { nx, ny });
                                    }
                                }
                            }
                        }
                        areaCount++;
                    }
                }
            }
            if (maxArea <= areaCount) {
                maxArea = areaCount;
            }
            dept++;
        }
        System.out.println(maxArea);
    }
}
