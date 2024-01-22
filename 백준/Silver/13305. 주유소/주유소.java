import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 제일 왼쪽에서 오른쪽까지의 최소 비용 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] roads = new int[n];

        int[] prices = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // 다음 도시가 더 싸면 거리만큼만 산다.
        long sum = 0;
        long answer = prices[1];

        for (int i = 1; i <= n - 1; i++) {
            answer = Math.min(answer, prices[i]);
            sum += answer * roads[i];
        }

        System.out.println(sum);

    }
}
