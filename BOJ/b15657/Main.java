package b15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] num;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        ans = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        print(0, 0);
        System.out.println(sb.toString());
    }

    private static void print(int start, int count) {
        if (m == count) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = start; i < n; i++) {
                ans[count] = num[i];
                print(i, count + 1);
            }
        }
    }
}
