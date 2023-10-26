package b15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);
        System.out.print(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int num : ans) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = start; i < N; i++) {
            if (before != arr[i]) {
                ans[depth] = arr[i];
                dfs(i, depth + 1);
                before = arr[i];
            }
        }
    }
}
