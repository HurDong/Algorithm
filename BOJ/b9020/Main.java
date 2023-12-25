package b9020;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int n1 = n / 2;
            int n2 = n / 2;
            while (true) {
                if (isPrime(n1) && isPrime(n2)) {
                    System.out.println(n1 + " " + n2);
                    break;
                }
                n1--;
                n2++;
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
