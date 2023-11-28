package b1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        // 0~v 만큼 ArrayList 배열 생성
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }
        int[] dist = dijkstra(v, graph, k);
        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static int[] dijkstra(int v, ArrayList<ArrayList<Node>> graph, int start) {
        int[] dist = new int[v + 1]; // 최단거리 저장
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curV = cur.vertex;
            if (dist[curV] < cur.weight) // 최단 거리보다 가중치가 높을 경우 다음 원소 추출
                continue;
            for (Node node : graph.get(curV)) { // 그 외의 경우 현재 점으로부터의 가중치 계산
                if (dist[node.vertex] > dist[curV] + node.weight) {
                    dist[node.vertex] = dist[curV] + node.weight;
                    pq.offer(new Node(node.vertex, dist[node.vertex]));
                }
            }
        }
        return dist;
    }
}
