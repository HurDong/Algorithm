package b1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int v, e;
    static int[] parents;
    static ArrayList<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parents = new int[v + 1];
        // 자기자신으로 먼저 parents 초기화
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a, b, c));
        }
        Collections.sort(nodes);
        int sum = 0;
        for (Node node : nodes) {
            if (find(node.start) != find(node.vertex)) {
                union(node.start, node.vertex);
                sum += node.weight;
            }
        }
        System.out.println(sum);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parents[y] = x;
        }
    }

    private static int find(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    public static class Node implements Comparable<Node> {
        int start;
        int vertex;
        int weight;

        public Node(int start, int vertex, int weight) {
            this.start = start;
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 오름차순
        }
    }
}