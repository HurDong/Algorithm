package b2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result = a * b * c;
        int[] num = new int[10];
        boolean meet = false;
        // 1000000000
        for (int i = 9; i >= 0; i--) {
            if (result > Math.pow(10, i)) {
                num[result / (int) Math.pow(10, i)]++;
                result = result % (int) Math.pow(10, i);
                meet = true;
            } else if (meet) {
                num[0]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(num[i]);
        }
    }
}
