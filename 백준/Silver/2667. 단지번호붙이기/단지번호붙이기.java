import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] house;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        house = new int[n][n];
        visited = new boolean[n][n];
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                house[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (house[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    visited[i][j] = true;
                    int[] dx = { -1, 1, 0, 0 };
                    int[] dy = { 0, 0, -1, 1 };
                    int count = 1;
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (house[nx][ny] == 1 && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    queue.add(new int[] { nx, ny });
                                    count++;
                                }
                            }
                        }
                    }
                    ans.add(count);
                }
            }
        }
        System.out.println(ans.size());
        while (!ans.isEmpty()) {
            System.out.println(ans.poll());
        }
    }
}
