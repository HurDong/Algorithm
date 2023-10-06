package b21736;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] campus = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                campus[i][j] = s.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startX, startY });
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        int ans = 0;
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (campus[nx][ny] == 'X' || visited[nx][ny])
                    continue;
                if (campus[nx][ny] == 'P')
                    ans++;
                queue.add(new int[] { nx, ny });
                visited[nx][ny] = true;
            }
        }
        if (ans > 0) {
            System.out.println(ans);
        } else {
            System.out.println("TT");
        }

    }

}
