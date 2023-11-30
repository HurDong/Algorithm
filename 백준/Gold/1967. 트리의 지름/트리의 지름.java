import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int vertex;
        int weight;

        Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    static ArrayList<Node> tree[];
    static boolean[] visited;
    static int n, dist = 0, far = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Node(b, c));
            tree[b].add(new Node(a, c));
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        visited[1] = true;
        dfs(1, 0); // Root노드로부터 가장 가중치가 큰 경로 탐색.
        visited = new boolean[n + 1];
        dist = 0;
        visited[far] = true; // far 노드로부터 가장 가중치가 큰 경로 탐색.
        dfs(far, 0);
        System.out.println(dist);
    }

    private static void dfs(int nodeNum, int distSum) {
        if (dist < distSum) {
            dist = distSum;
            far = nodeNum;
        }
        for (Node next : tree[nodeNum]) {
            if (!visited[next.vertex]) {
                visited[next.vertex] = true;
                dfs(next.vertex, distSum + next.weight);
            }
        }
    }
}
