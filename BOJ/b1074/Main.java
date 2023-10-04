package b1074;

import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int num = 0;
    static int r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        // 4등분 하고 또 4등분하고 더 이상 안 나눠질 떄 까지
        draw(n, 0, 0);
    }

    static public void draw(int n, int a, int b) {
        if (a == r && b == c) {
            System.out.println(num);
            return;
        }
        if (r >= a && r < (a + Math.pow(2, n)) && c >= b && c < (b + Math.pow(2, n))) {
            int len = (int) Math.pow(2, n - 1);
            draw(n - 1, a, b);
            draw(n - 1, a, b + len);
            draw(n - 1, a + len, b);
            draw(n - 1, a + len, b + len);
        } else {
            num += Math.pow(2, 2 * n);
        }

    }
}
