import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기 N 읽기
        int N = Integer.parseInt(br.readLine());

        // 배열 A와 B 초기화
        int[] A = new int[N];
        int[] B = new int[N];

        // 배열 A 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 B 읽기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A와 B 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // 최소 합 S 계산
        int S = 0;
        for (int i = 0; i < N; ++i) {
            S += A[i] * B[N - 1 - i];
        }

        // 결과 출력
        System.out.println(S);
    }
}
