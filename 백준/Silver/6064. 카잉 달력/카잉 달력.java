import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int maxYear = m * n; // 최대 연도
            int answer = -1; // 결과값 초기화

            for (int i = x; i <= maxYear; i += m) {
                int tempY = (i - 1) % n + 1; // m으로 나눈 나머지에 1을 더해준다.
                if (tempY == y) {
                    answer = i;
                    break;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
