package b4158;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0)
                break;

            int[] cds1 = new int[N];
            int[] cds2 = new int[M];

            for (int i = 0; i < N; i++) {
                cds1[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < M; i++) {
                cds2[i] = Integer.parseInt(br.readLine());
            }

            int count = 0; // 중복된 CD 수
            int i = 0, j = 0; // 투 포인터 초기화

            while (i < N && j < M) {
                if (cds1[i] == cds2[j]) {
                    count++;
                    i++;
                    j++;
                } else if (cds1[i] < cds2[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            sb.append(count + "\n");
        }
        System.out.println(sb.toString());
    }
}
