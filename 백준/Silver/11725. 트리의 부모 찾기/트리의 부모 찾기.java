import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        int[] parents = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, tree, parents, visited);
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i] + "\n");
        }
        System.out.print(sb.toString());

    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> tree, int[] parents, boolean[] visited) {
        for (int child : tree.get(node)) {
            if (!visited[child]) {
                visited[child] = true;
                parents[child] = node;
                dfs(child, tree, parents, visited);
            }
        }
    }
}