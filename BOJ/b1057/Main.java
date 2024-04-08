package b1057;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int A = sc.nextInt();

        int B = sc.nextInt();

        int round = 0;

        while (A != B) {
            A = A / 2 + A % 2; // 김지민의 다음 라운드 번호
            B = B / 2 + B % 2; // 임한수의 다음 라운드 번호
            round++; // 라운드 증가
        }

        System.out.println(round);
    }
}
