package b1167;

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

    static ArrayList<Node>[] tree;
    static int dist = 0, far = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        tree = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                } else {
                    int weight = Integer.parseInt(st.nextToken());
                    tree[start].add(new Node(num, weight));
                }
            }
        }
        if (v == 1) {
            System.out.println(dist);
            return;
        }
        dfs(1, 0);
        visited = new boolean[v + 1];
        dfs(far, 0);
        System.out.println(dist);
    }

    private static void dfs(int nodeNum, int distSum) {
        if (dist < distSum) {
            dist = distSum;
            far = nodeNum;
        }
        visited[nodeNum] = true;
        for (Node next : tree[nodeNum]) {
            if (!visited[next.vertex]) {
                dfs(next.vertex, distSum + next.weight);
                visited[next.vertex] = true;
            }
        }
    }
}
// 1->3
// 2->4
// 3->4
// 4->2 4->5
