package b14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int big = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (big < find(i, j)) {
                    big = find(i, j);
                }
            }
        }
        // 범위 검사
        // checkRange(x,y);

    }

    private static int find(int i, int j) {
        // i와 j가 좌측 상단에 있다고 항상 가정.
        // 이러면 나올 수 있는 모양이
        return 0;
    }
}
