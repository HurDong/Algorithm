package b15654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr, ans;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        ans = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb.toString());
    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int num : ans) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ans[depth] = arr[i];
                    dfs(i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
