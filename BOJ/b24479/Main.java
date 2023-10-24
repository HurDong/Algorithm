package b24479;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int order = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i] == 0 ? 0 : visited[i]);
        }
    }

    public static void dfs(int node) {
        visited[node] = order++;
        for (int next : graph[node]) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }
}
