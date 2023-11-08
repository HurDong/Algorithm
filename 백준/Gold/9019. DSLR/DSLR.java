import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int max = 10000;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            sb.append(bfs(A, B) + "\n");
        }
        System.out.println(sb.toString());
    }

    private static String bfs(int a, int b) {
        boolean[] visited = new boolean[max];
        String[] path = new String[max];
        Arrays.fill(path, ""); // path 배열을 ""로 먼저 채운다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == b) {
                return path[cur];
            }
            int D = (2 * cur) % max;
            int S = 0;
            if (cur == 0) {
                S = 9999;
            } else {
                S = cur - 1;
            }
            int L = (cur % 1000) * 10 + cur / 1000;
            int R = (cur / 10) + (cur % 10) * 1000;
            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                path[D] = path[cur] + "D";
            }

            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                path[S] = path[cur] + "S";
            }

            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                path[L] = path[cur] + "L";
            }

            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                path[R] = path[cur] + "R";
            }
        }
        return "";
    }
}
