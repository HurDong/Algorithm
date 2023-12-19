package b1343;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String board = sc.nextLine();
        sc.close();

        String result = replacePolynomino(board);
        System.out.println(result);
    }

    private static String replacePolynomino(String board) {
        StringBuilder sb = new StringBuilder();
        int countX = 0;

        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == 'X') {
                countX++;
            } else {
                if (countX % 2 != 0) {
                    return "-1"; // 'X'의 개수가 홀수이면 불가능
                }

                sb.append(replaceWithPolynomino(countX));
                sb.append('.'); // '.'을 그대로 추가
                countX = 0; // 'X' 개수 초기화
            }
        }

        if (countX % 2 != 0) {
            return "-1";
        }
        sb.append(replaceWithPolynomino(countX));

        return sb.toString();
    }

    private static String replaceWithPolynomino(int countX) {
        StringBuilder sb = new StringBuilder();
        while (countX >= 4) {
            sb.append("AAAA");
            countX -= 4;
        }

        if (countX == 2) {
            sb.append("BB");
        }
        return sb.toString();
    }
}
