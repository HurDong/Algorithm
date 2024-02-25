package b1358;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt();
        int H = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int P = sc.nextInt();

        int count = 0;

        for (int i = 0; i < P; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 직사각형 내부에 있는지 판별
            if (x >= X && x <= X + W && y >= Y && y <= Y + H) {
                count++;
            } else
            // 왼쪽 반원 내부에 있는지 판별
            {
                if (Math.pow(x - X, 2) + Math.pow(y - (Y + H / 2), 2) <= Math.pow(H / 2, 2)) {
                    count++;
                }
                // 오른쪽 반원 내부에 있는지 판별
                else if (Math.pow(x - (X + W), 2) + Math.pow(y - (Y + H / 2), 2) <= Math.pow(H / 2, 2)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
