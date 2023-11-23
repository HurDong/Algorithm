import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int ai = 0, bi = 0;

        while (ai < N && bi < M) {
            if (A[ai] < B[bi]) {
                sb.append(A[ai++]).append(' ');
            } else {
                sb.append(B[bi++]).append(' ');
            }
        }

        while (ai < N) {
            sb.append(A[ai++]).append(' ');
        }

        while (bi < M) {
            sb.append(B[bi++]).append(' ');
        }

        System.out.println(sb.toString());
    }
}
