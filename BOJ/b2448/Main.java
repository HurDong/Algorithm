package b2448;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 높이 -> 3 6 12 24 48 ...
        draw(N);
    }

    private static void draw(int n) {
        if (n == 3) {

        }
        draw(n / 2);
        draw(n / 2);
        draw(n / 2);
    }
}
