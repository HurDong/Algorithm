import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] A = new int[n];
            int[] B = new int[m];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);

            Arrays.sort(B);

            int idxA = 0;

            int idxB = 0;

            int count = 0;

            while (idxA < n) {
                if (idxB == m) {
                    idxA++;
                    idxB = 0;
                } else {
                    if (A[idxA] > B[idxB]) {
                        count++;
                        idxB++;
                    } else {
                        idxA++;
                        idxB = 0;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
