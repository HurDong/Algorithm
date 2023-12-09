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
        int vertex;
        int weight;

        Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        // 1~N에서 X까지에 대한 최단거리 구하기
        int[] startDist = dijkstra(N, graph, X);

        int ans = Integer.MIN_VALUE;

        // X에서 1~N까지에 대한 최단거리 구하기
        for (int i = 1; i <= N; i++) {
            if (startDist[i] != INF) {
                int[] backDist = dijkstra(N, graph, i);
                // 왕복이므로 서로 더해준다.
                startDist[i] += backDist[X];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (startDist[i] != INF && ans < startDist[i]) {
                ans = startDist[i];
            }
        }

        System.out.println(ans);
    }

    private static int[] dijkstra(int n, ArrayList<ArrayList<Node>> graph, int x) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF); // 먼저 최대로 채워 넣자.
        dist[x] = 0; // 자기 자신은 0
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.vertex;
            int w = cur.weight;
            if (dist[v] < w) {
                continue;
            } else {
                for (Node node : graph.get(v)) {
                    if (dist[node.vertex] > dist[v] + node.weight) {
                        dist[node.vertex] = dist[v] + node.weight;
                        pq.add(new Node(node.vertex, dist[node.vertex]));
                    }
                }
            }
        }
        return dist;
    }
}
