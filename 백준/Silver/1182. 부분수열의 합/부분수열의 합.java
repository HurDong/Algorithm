import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, count = 0;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // S가 0일 때, 공집합도 카운트에 포함되므로, 공집합을 제외하기 위해 count를 1 감소
        if (S == 0)
            count--;

        System.out.println(count);
    }

    static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 인덱스의 수를 포함하는 경우
        dfs(index + 1, sum + numbers[index]);

        // 현재 인덱스의 수를 포함하지 않는 경우
        dfs(index + 1, sum);
    }
}
