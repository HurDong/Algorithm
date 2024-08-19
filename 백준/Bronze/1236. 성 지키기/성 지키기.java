import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 성의 행 수
        int m = scanner.nextInt(); // 성의 열 수
        char[][] castle = new char[n][m];

        for (int i = 0; i < n; i++) {
            castle[i] = scanner.next().toCharArray();
        }

        int rowGuard = 0; // 경비원이 없는 행의 수
        int colGuard = 0; // 경비원이 없는 열의 수

        // 각 행에 경비원이 있는지 확인
        for (int i = 0; i < n; i++) {
            boolean hasGuard = false;
            for (int j = 0; j < m; j++) {
                if (castle[i][j] == 'X') {
                    hasGuard = true;
                    break;
                }
            }
            if (!hasGuard) {
                rowGuard++;
            }
        }

        // 각 열에 경비원이 있는지 확인
        for (int j = 0; j < m; j++) {
            boolean hasGuard = false;
            for (int i = 0; i < n; i++) {
                if (castle[i][j] == 'X') {
                    hasGuard = true;
                    break;
                }
            }
            if (!hasGuard) {
                colGuard++;
            }
        }

        // 필요한 경비원의 수는 행과 열에서 더 큰 값
        System.out.println(Math.max(rowGuard, colGuard));
    }
}
