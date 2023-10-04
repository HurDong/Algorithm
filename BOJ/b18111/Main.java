package b18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int minTime = Integer.MAX_VALUE;
        int height = 0;
        for (int i = 0; i <= 256; i++) {
            int time = 0;
            int blocks = b;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int dif = field[j][k] - i;
                    if (dif > 0) {
                        time += (2 * dif);
                        blocks += dif; // 양수
                    } else if (dif < 0) {
                        time += (-dif);
                        blocks += dif; // 음수
                    }
                }
            }
            if (blocks >= 0) {
                if (time <= minTime) {
                    minTime = time;
                    height = i;
                }
            }
        }
        System.out.println(minTime + " " + height);
    }
}
