package b1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;
    static int N;
    static int[][] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        papers = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(minus + "\n" + zero + "\n" + plus);
    }

    private static void divide(int x, int y, int index) {
        // 먼저 해당 구간이 같은 숫자로 이루어져있는지 확인
        int target = papers[x][y];
        boolean allSame = true;
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                if (target != papers[x + i][y + j]) {
                    allSame = false;

                }
            }
        }
        // 다 같지 않으면 분할 정복
        if (!allSame) {
            divide(x, y, index / 3);
            divide(x + index / 3, y, index / 3);
            divide(x + (index / 3) * 2, y, index / 3);

            divide(x, y + index / 3, index / 3);
            divide(x + index / 3, y + index / 3, index / 3);
            divide(x + (index / 3) * 2, y + index / 3, index / 3);

            divide(x, y + (index / 3) * 2, index / 3);
            divide(x + index / 3, y + (index / 3) * 2, index / 3);
            divide(x + (index / 3) * 2, y + (index / 3) * 2, index / 3);
        }
        // 같다면 알맞은 변수 증가
        else {
            if (target == -1) {
                minus++;
            } else if (target == 0) {
                zero++;
            } else {
                plus++;
            }
        }
    }
}
