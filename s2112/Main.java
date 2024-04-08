package s2112;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> cGraph;
    static List<List<Integer>> rGraph;
    static int s, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(st.nextToken());

        cGraph = new ArrayList<>();

        rGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            cGraph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            cGraph.get(start).add(end);
            rGraph.get(end).add(start);
        }

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());

        t = Integer.parseInt(st.nextToken());

        Set<Integer> s1 = new HashSet<>();

        Set<Integer> s2 = new HashSet<>();

        dfs(s, t, cGraph, s1, new boolean[n + 1]);

        dfs(t, -1, rGraph, s2, new boolean[n + 1]);

        s1.retainAll(s2); // retainAll을 이용해 s1을 s1와 s2의 교집합으로 설정

        Set<Integer> s3 = new HashSet<>();

        Set<Integer> s4 = new HashSet<>();

        dfs(t, s, cGraph, s3, new boolean[n + 1]);

        dfs(s, -1, rGraph, s4, new boolean[n + 1]);

        s3.retainAll(s4); // s3도 s3와 s4의 교집합으로

        int count = 0;

        s1.retainAll(s3); // s1와 s3를 합쳐 전체 정방향 역방향 그래프의 교집합을 구함

        count = s1.size();

        if (s1.contains(s))
            count--;

        if (s1.contains(t))
            count--;

        System.out.println(count);
    }

    private static void dfs(int start, int end, List<List<Integer>> graph, Set<Integer> set, boolean[] visited) {
        if (end != -1 && start == end) {
            return;
        }
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) {
                visited[next] = true;
                set.add(next);
                dfs(next, end, graph, set, visited);
            }
        }
    }
}