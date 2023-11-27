import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { n, 0 }); // x : 현재 위치, y : 시간
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]] = true;
            if (cur[0] == k) {
                return cur[1];
            } else {
                // 시간이 안 늘어나므로 *2부터 먼저 연산
                if (cur[0] * 2 <= 100000 && !visited[cur[0] * 2]) {
                    queue.offer(new int[] { cur[0] * 2, cur[1] });
                }
                if (cur[0] - 1 >= 0 && !visited[cur[0] - 1]) {
                    queue.offer(new int[] { cur[0] - 1, cur[1] + 1 });
                }
                if (cur[0] + 1 <= 100000 && !visited[cur[0] + 1]) {
                    queue.offer(new int[] { cur[0] + 1, cur[1] + 1 });
                }

            }
        }
        return -1;
    }

}
