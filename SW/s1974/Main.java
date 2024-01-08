package SW.s1974;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testNum = 1;
        while (T-- > 0) {
            int[][] sudoku = new int[9][9];
            int answer = 1;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }
            // 가로 9 세로 9 사각형 9을 체크해보자.
            for (int i = 0; i < 9; i++) {
                int sum1 = 0; // 가로
                int sum2 = 0; // 세로
                for (int j = 0; j < 9; j++) {
                    sum1 += sudoku[i][j];
                    sum2 += sudoku[j][i];
                }
                if (sum1 != 45 || sum2 != 45) {
                    answer = 0;
                    break;
                }
            }
            for (int row = 0; row < 9; row += 3) {
                for (int col = 0; col < 9; col += 3) {
                    int sum3 = 0;
                    for (int i = row; i < row + 3; i++) {
                        for (int j = col; j < col + 3; j++) {
                            sum3 += sudoku[i][j];
                        }
                    }
                    if (sum3 != 45) {
                        answer = 0;
                        break;
                    }
                }
            }
            System.out.println("#" + testNum + " " + answer);
            testNum++;
        }
    }
}
