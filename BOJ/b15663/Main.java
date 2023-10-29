package b15663;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        ans = new int[M];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
        } else {
            int prev = -1;
            for (int i = 0; i < N; i++) {
                if (!visited[i] && prev != arr[i]) {
                    visited[i] = true;
                    ans[depth] = arr[i];
                    prev = arr[i];
                    dfs(depth + 1);
                    visited[i] = false;
                }

            }
        }
    }

}
