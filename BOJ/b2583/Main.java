package b2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] paper = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = 1;
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    paper[k][j] = 0;
                }
            }
        }
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && paper[i][j] == 1) {
                    int size = 1;
                    count++;
                    visited[i][j] = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] { i, j });
                    int[] dx = { -1, 1, 0, 0 };
                    int[] dy = { 0, 0, -1, 1 };
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];
                            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                                if (!visited[nx][ny] && paper[nx][ny] == 1) {
                                    size++;
                                    visited[nx][ny] = true;
                                    queue.add(new int[] { nx, ny });
                                }
                            }
                        }
                    }
                    ans.add(size);
                }
            }
        }
        System.out.println(count);
        while (!ans.isEmpty()) {
            System.out.print(ans.poll() + " ");
        }
    }
}
