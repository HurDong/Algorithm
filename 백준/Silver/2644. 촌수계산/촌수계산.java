import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] family;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int person1 = sc.nextInt();
        int person2 = sc.nextInt();
        int m = sc.nextInt();

        family = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            family[x][y] = family[y][x] = 1;
        }

        System.out.println(bfs(person1, person2));
    }

    static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[n + 1];

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == end) {
                return degree[current];
            }

            for (int i = 1; i <= n; i++) {
                if (family[current][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    degree[i] = degree[current] + 1;
                }
            }
        }

        return -1;
    }
}
