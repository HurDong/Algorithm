package b16928;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] game = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) {
        // 출발 1 도착 100
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N + M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            game[a] = b;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int[] count = new int[101]; // 각 위치까지 도달하는 필요 주사위 수
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 100) {
                System.out.println(count[cur]);
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100)
                    continue;
                if (game[next] != 0) {
                    next = game[next];
                }
                if (!visited[next]) {
                    visited[next] = true;
                    count[next] = count[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }

}
