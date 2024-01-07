package b12851;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[] dist = new int[100001]; // n에서 해당 배열 인덱스까지 걸리는 최소 시간
        int[] answers = new int[100001]; // dist[]의 경우의 수
        Arrays.fill(dist, -1);
        dist[n] = 0;
        answers[n] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i == 0) {
                    nx = cur - 1;
                } else if (i == 1) {
                    nx = cur + 1;
                } else if (i == 2) {
                    nx = cur * 2;
                }
                if (nx >= 0 && nx <= 100000) {
                    // 최신화가 안되었다면.
                    if (dist[nx] == -1) {
                        dist[nx] = dist[cur] + 1; // 한칸 이동이든 순간이동 시간은 +1
                        answers[nx] = answers[cur];
                        queue.add(nx);
                        // 이미 방문했지만 다른 방법으로 방문할 수 있는 경우
                    } else if (dist[nx] == dist[cur] + 1) {
                        answers[nx] += answers[cur];
                    }
                }
            }
        }
        System.out.println(dist[k] + "\n" + answers[k]);
    }
}
