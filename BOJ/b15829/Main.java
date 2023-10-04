package b15829;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String c = sc.next();
        long sum = 0;
        long temp = 1;
        int M = 1234567891;
        for (int i = 0; i < n; i++) {
            sum = (sum + (c.charAt(i) - 96) * temp) % M;
            temp = (temp * 31) % M;
        }
        System.out.println(sum);
    }
}
