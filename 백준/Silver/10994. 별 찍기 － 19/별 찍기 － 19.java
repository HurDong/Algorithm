import java.util.Scanner;

public class Main {
    static char[][] arr;

    public static void star(int x, int y, int n, boolean blank) {
        // 공백 채우기
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더 이상 쪼갤 수 없는 블록일 때
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = 4 * n - 3;
        int count = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // 가장자리에 별 찍기
                if (i == x || i == x + size - 1 || j == y || j == y + size - 1) {
                    arr[i][j] = '*';
                }
            }
        }

        // 내부 공백 처리를 위한 재귀 호출
        star(x + 2, y + 2, n - 1, false);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[4 * n - 3][4 * n - 3];

        // 배열 초기화
        for (int i = 0; i < 4 * n - 3; i++) {
            for (int j = 0; j < 4 * n - 3; j++) {
                arr[i][j] = ' ';
            }
        }

        // 별 찍기
        star(0, 0, n, false);

        // 결과 출력
        for (int i = 0; i < 4 * n - 3; i++) {
            System.out.println(arr[i]);
        }
    }
}
