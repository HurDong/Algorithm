import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Ground>> ground; // 그래프 저장
    static int n, m, r; // 전체 노드 수, 수색 범위, 그래프 간선 수
    static int[] items; // 방문 노드의 획득 item 수
    static int answer = 0; // item의 최댓값 저장
    static int[] results;

    public static void main(String[] args) {
        // 양방향 통행 가능, 떨어진 위치에서 거쳐가든 바로가든 수색범위까지만 가능
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        ground = new ArrayList<>();
        items = new int[n + 1];
        results = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            ground.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }
        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            ground.get(a).add(new Ground(b, c));
            ground.get(b).add(new Ground(a, c));
        }
        /*
         * for (int i = 1; i <= n; i++) {
         * System.out.println(i + " 번째 : " + ground.get(i).size());
         * for (int j = 0; j < ground.get(i).size(); j++) {
         * System.out.println("연결 점 :" + ground.get(i).get(j).vertex + " 가중치 : " +
         * ground.get(i).get(j).weight);
         * }
         * }
         */
        for (int i = 1; i <= n; i++) {
            solve(i);
            /* System.out.println(answer); */
        }
        System.out.println(answer);
    }

    private static void solve(int startNode) {
        boolean[] visited = new boolean[n + 1];
        boolean[] resulted = new boolean[n + 1];
        dfs(startNode, startNode, visited, resulted, m);
    }

    private static void dfs(int startNode, int curNode, boolean[] visited, boolean[] resulted, int curWeight) {
        // 1에서 2를 갈때보다 1에서 3을 거쳐 2를 갈때 더 짧은 길이면 더 다양한 루트로 갈 수 있다. -> resulted 배열을 만들어 해당
        // node의 items가 추가 되었으면 추가하지 않는다.
        visited[curNode] = true;
        if (!resulted[curNode]) {
            results[startNode] += items[curNode];
            resulted[curNode] = true;
        }
        for (int i = 0; i < ground.get(curNode).size(); i++) {
            int nextVertex = ground.get(curNode).get(i).vertex;
            int nextWeight = ground.get(curNode).get(i).weight;
            if (!visited[nextVertex] && nextWeight <= curWeight) {
                dfs(startNode, nextVertex, visited, resulted, curWeight - nextWeight);
            }
        }
        answer = Math.max(answer, results[startNode]);
        visited[curNode] = false;
    }

    public static class Ground {
        int vertex;
        int weight;

        Ground(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

    }
}

/*
 * 6 5 6
 * 1 2 3 4 5 6
 * 1 2 1
 * 2 3 1
 * 3 4 1
 * 4 5 1
 * 1 5 5
 * 5 6 1
 */