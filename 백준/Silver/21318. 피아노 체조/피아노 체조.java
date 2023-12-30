import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int[] sheet = new int[N + 1];
        int[] mistake = new int[N + 1];
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sheet[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            if (sheet[i] > sheet[i + 1]) {
                mistake[i] = 1;
            }
        }
        for (int i = 1; i <= N; i++) {
            sum[i] += sum[i - 1] + mistake[i - 1];
        }
        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append((sum[end] - sum[start]) + "\n");
        }
        System.out.println(sb.toString());

    }
}