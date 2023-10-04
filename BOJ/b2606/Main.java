package b2606;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Integer>> com;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        com = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            com.add(new ArrayList<>());
        }
        for (int i = 0; i < p; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            com.get(a).add(b);
            com.get(b).add(a);
        }
        dfs(1);
        System.out.println(count - 1);
    }

    static public void dfs(int node) {
        visited[node] = true;
        count++;
        for (int i = 0; i < com.get(node).size(); i++) {
            int next = com.get(node).get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
