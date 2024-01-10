package b2448;

import java.util.Scanner;

public class Main {
    static char[][] star;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt(); // 높이 -> 3 6 12 24 48 ...
        star = new char[N][2 * N];
        // 먼저 빈칸으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                star[i][j] = ' ';
            }
        }

        // (0,N-1) 부터 시작해 재귀를 돌며 범위를 좁혀나가기
        drawStar(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void drawStar(int x, int y, int N) {
        // 더 이상 나눠지지 않을 때 하드코딩으로 별 그리기..
        // star[x+1][y] 비우기
        if (N == 3) {
            star[x][y] = '*';

            star[x + 1][y - 1] = '*';
            star[x + 1][y + 1] = '*';

            star[x + 2][y - 2] = '*';
            star[x + 2][y - 1] = '*';
            star[x + 2][y] = '*';
            star[x + 2][y + 1] = '*';
            star[x + 2][y + 2] = '*';

            return;
        }

        drawStar(x, y, N / 2);
        drawStar(x + N / 2, y - N / 2, N / 2);
        drawStar(x + N / 2, y + N / 2, N / 2);
    }
}
