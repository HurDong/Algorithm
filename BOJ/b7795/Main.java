package b7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

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
            // A 입력
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            // B 입력
            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            // A 오름차순으로 정렬
            Arrays.sort(A);
            // B 오름차순으로 정렬
            Arrays.sort(B);
            // 투 포인터에서 A의 포인터
            int idxA = 0;
            // 투 포인터에서 B의 포인터
            int idxB = 0;
            // 답
            int count = 0;
            // 투 포인터 알고리즘
            while (idxA < n) {
                // B포인터가 끝지점으로 가면 B를 처음 지점으로 보내고 A포인터 와 답 증가
                if (idxB == m) {
                    idxA++;
                    idxB = 0;
                } else {
                    // A가 B보다 크면 B포인터와 답 증가
                    if (A[idxA] > B[idxB]) {
                        count++;
                        idxB++;
                    }
                    // 아니라면 A포인터 증가, B포인터는 0으로
                    else {
                        idxA++;
                        idxB = 0;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb.toString());
    }
}
