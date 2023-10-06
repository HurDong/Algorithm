package b1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int minBacon = Integer.MAX_VALUE;
        int person = 0;
        for (int i = 1; i <= n; i++) {
            int bacon = bfs(i, graph, n);
            if (bacon < minBacon) {
                minBacon = bacon;
                person = i;
            }
        }
        System.out.println(person);
    }

    private static int bfs(int start, HashMap<Integer, List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n + 1]; // 시작점에서 dist[n]점까지의 거리
        Arrays.fill(dist, -1); // 최단거리 -1로 먼저 설정 0과 겹치면 안되니
        queue.add(start);
        dist[start] = 0;
        int bacon = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) { // 미방문 시 true
                    dist[next] = dist[cur] + 1;
                    bacon += dist[next];
                    queue.add(next);
                }
            }
        }
        return bacon;
    }
}
