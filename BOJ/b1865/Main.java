package b1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static final int INF = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static class Edge {
        int vertex;
        int weight;

        Edge(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        // 코멘트 : 다익스트라와 유사해보이지만, 가중치를 이용한 최단거리 계산이 아닌 음수 사이클 존재 여부를 찾는다는 것에서 큰 차이점이 있다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.get(a).add(new Edge(b, c));
                edges.get(b).add(new Edge(a, c));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.get(a).add(new Edge(b, c * (-1)));
            }

            boolean isMinusCycle = false;

            for (int i = 1; i <= N; i++) {
                // MinusCycle이 있을경우
                if (bellmanFord(edges, N, i)) {
                    isMinusCycle = true;
                    break;
                }
            }
            // 모든 정점에 대하여 음수 사이클이 있을 경우
            if (isMinusCycle) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean bellmanFord(ArrayList<ArrayList<Edge>> edges, int N, int start) {
        // 벨만포드 알고리즘 -> 음수 가중치
        // 음수 사이클이 있으면 -> tur를 반환
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;
        for (int i = 1; i < N; i++) {
            update = false;
            for (int j = 1; j < N + 1; j++) {
                int cur = j;
                for (Edge edge : edges.get(j)) {
                    if (dist[j] != INF && dist[edge.vertex] > dist[j] + edge.weight) {
                        dist[edge.vertex] = dist[j] + edge.weight;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        // update 발생했을 시 음수 사이클이 있는지 확인해야함.
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Edge edge : edges.get(i)) {
                    if (dist[i] != INF && dist[edge.vertex] > dist[i] + edge.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
