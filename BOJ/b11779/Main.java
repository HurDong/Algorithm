package b11779;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }

    public static final int INF = 987654321;
    public static int[] dist;
    public static int[] prev; // 해당 점이 어느 점으로부터 유래했는지 알기 위해 설정.

    public static List<List<Node>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();

        list = new ArrayList<>();
        dist = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dist, INF); // 가장 큰 값으로 일단 채움.

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            list.get(start).add(new Node(end, weight));
        }

        int startCity = sc.nextInt();
        int endCity = sc.nextInt();

        // startCity에 대해서 모든 노드 최단거리 구하기.
        dijk(startCity);

        sb.append(dist[endCity] + "\n");
        Stack<Integer> stack = new Stack<>();
        while (endCity != 0) {
            stack.push(endCity);
            endCity = prev[endCity];
        }
        sb.append(stack.size() + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }

    private static void dijk(int startCity) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[dist.length];
        queue.add(new Node(startCity, 0));
        dist[startCity] = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.vertex;
            // 방문 했으면 건너 뛴다.
            if (check[cur])
                continue;
            check[cur] = true;
            // 연결된 vertex 모두 순회
            for (Node node : list.get(cur)) {
                if (dist[node.vertex] > dist[cur] + node.weight) {
                    dist[node.vertex] = dist[cur] + node.weight;
                    prev[node.vertex] = cur;
                    queue.add(new Node(node.vertex, dist[node.vertex]));
                }
            }
        }
    }
}
