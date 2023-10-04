package b2475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        int[] numSquare = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
            numSquare[i] = num[i] * num[i];
            sum += numSquare[i];
        }
        System.out.println(sum % 10);
    }
}
