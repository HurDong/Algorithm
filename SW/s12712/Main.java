package SW.s12712;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int idx = 1;
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            int[] pdx = { -1, 1, 0, 0 };
            int[] pdy = { 0, 0, -1, 1 };
            int[] cdx = { 1, 1, -1, -1 };
            int[] cdy = { 1, -1, 1, -1 };
            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = board[i][j];
                    for (int k = 1; k < M; k++) {
                        for (int l = 0; l < 4; l++) {
                            int nx = i + pdx[l] * k;
                            int ny = j + pdy[l] * k;
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                temp += board[nx][ny];
                            }
                        }
                    }
                    answer = Math.max(temp, answer);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = board[i][j];
                    for (int k = 1; k < M; k++) {
                        for (int l = 0; l < 4; l++) {
                            int nx = i + cdx[l] * k;
                            int ny = j + cdy[l] * k;
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                temp += board[nx][ny];
                            }
                        }
                    }
                    answer = Math.max(temp, answer);
                }
            }
            System.out.println("#" + idx + " " + answer);
            idx++;
        }
    }
}
