package SW.s1961;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testNum = 1;
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            int[][] board90 = rotate90(board, n);
            int[][] board180 = rotate90(board90, n);
            int[][] board270 = rotate90(board180, n);
            System.out.println("#" + testNum);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(board180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(board270[i][j]);
                }
                System.out.println();
            }
            testNum++;
        }
    }

    private static int[][] rotate90(int[][] board, int n) {
        int[][] board90 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board90[j][n - 1 - i] = board[i][j];
            }
        }
        return board90;
    }
}
