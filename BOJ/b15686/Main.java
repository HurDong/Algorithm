package b15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<int[]> chicken, house;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1)
                    house.add(new int[] { i, j });
                else if (type == 2)
                    chicken.add(new int[] { i, j });
            }
        }
        backTracking(0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void backTracking(int start, ArrayList<int[]> selected) {
        if (selected.size() == m) {
            answer = Math.min(answer, calculateDist(selected));
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            selected.add(chicken.get(i)); // i번째 치킨집 추가
            backTracking(i + 1, selected);
            selected.remove(selected.size() - 1); // 추가했던 치킨집 삭제
        }

    }

    private static int calculateDist(ArrayList<int[]> list) {
        int sum = 0;
        for (int[] home : house) {
            int dist = Integer.MAX_VALUE;
            for (int[] chickenHome : list) {
                dist = Math.min(dist, Math.abs(home[0] - chickenHome[0]) + Math.abs(home[1] - chickenHome[1]));
            }
            sum += dist;
        }
        return sum;
    }
}
