import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            k = sc.nextInt();
            // 0 입력 받을 때까지 진행
            if (k == 0)
                break;
            arr = new int[k];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println();
        }
    }

    // 완탐
    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
