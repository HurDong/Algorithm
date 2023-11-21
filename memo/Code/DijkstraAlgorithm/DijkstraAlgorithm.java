package memo.Code.DijkstraAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    // 무한대 저장
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // 우선순위 큐에서 가중치에 따라 정렬
        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        StringBuilder sb = new StringBuilder();
        int[][] graph = new int[][] {
                { 0, 10, 0, 0, 5 },
                { 0, 0, 1, 0, 2 },
                { 0, 0, 0, 4, 0 },
                { 7, 0, 6, 0, 0 },
                { 0, 3, 9, 2, 0 }
        };
        // 0번 정점에서 시작하여 다른 정점까지의 최단 거리 계산
        for (int i = 0; i < V; i++) {
            int[] dist = dijkstra(V, graph, i);
            sb.append(i + "번째 정점에서 각 정점까지의 최단 거리 : " + Arrays.toString(dist) + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int[] dijkstra(int v, int[][] graph, int start) {
        // 정점 start에서 각 정점까지의 최단 거리를 저장할 배열
        int[] dist = new int[v];
        // 해당 정점 방문했는지 확인하는 배열
        boolean[] visited = new boolean[v];
        // 모든 거리를 무한대로 초기화
        Arrays.fill(dist, INF);

        dist[start] = 0;

        // 현재까지 발견된 가장 짧은 경로를 가진 정점을 찾기 위한 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.vertex;

            if (visited[curVertex])
                continue;
            visited[curVertex] = true;

            for (int i = 0; i < v; i++) {
                // 방문하지 않았고, 연결되어 있으면서 거리가 더 짧은 경우만 생각
                if (!visited[i] && graph[curVertex][i] != 0
                        && dist[i] > dist[curVertex] + graph[curVertex][i]) {
                    // 짧은 거리로 변경
                    dist[i] = dist[curVertex] + graph[curVertex][i];
                    pq.offer(new Node(i, dist[i]));
                }
            }
        }
        return dist;
    }
}
