import java.util.Scanner;

public class Main {
    static final int INF = 100000 * 100 + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else {
                    graph[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (graph[a][b] > c) {
                graph[a][b] = c;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF)
                    System.out.print("0 ");
                else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
