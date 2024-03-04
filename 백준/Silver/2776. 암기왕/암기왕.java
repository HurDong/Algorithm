import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            HashSet<Integer> set = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 수첩2에 적힌 모든 숫자를 HashSet에 저장
            for (int j = 0; j < N; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine()); // 수첩2에 적힌 숫자의 개수

            st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();

            // 수첩1의 숫자가 수첩2(HashSet)에 있는지 확인
            for (int j = 0; j < M; j++) {
                if (set.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }

            System.out.print(sb);
        }
    }
}
