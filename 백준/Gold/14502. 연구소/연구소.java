import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] lab;
    static int n, m;
    static int size = 0; // 3이면 return

    public static void main(String[] args) {
        // 벽 무조건 3개. -> 브루트포스로 모든 0에 대해서 하는 것이 맞을 것 같다.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lab = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lab[i][j] = sc.nextInt();
            }
        }
        createWall(0, 0, 0);
        System.out.println(size);
    }

    private static void createWall(int wallCount, int x, int y) {
        if (wallCount == 3) {
            size = Math.max(size, bfs());
            return;
        } else {
            for (int i = x; i < n; i++) {
                for (int j = (i == x ? y : 0); j < m; j++) { // 같은 행이면 y부터 아니라면 다음 줄 0부터
                    if (lab[i][j] == 0) {
                        lab[i][j] = 1;
                        createWall(wallCount + 1, i, j + 1);
                        lab[i][j] = 0;
                    }
                }

            }
        }
    }

    private static int bfs() {
        int[][] tempLab = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempLab[i][j] = lab[i][j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempLab[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (tempLab[nx][ny] == 0) {
                        queue.add(new int[] { nx, ny });
                        tempLab[nx][ny] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempLab[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
