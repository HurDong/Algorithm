package b1629;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        System.out.println(multiply(A, B, C));
    }

    private static long multiply(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        long temp = multiply(a, b / 2, c);
        temp = (temp * temp) % c;
        // A^4n = (A^2n)^2 = ((A^n)^2)^2 = ...
        if (b % 2 == 0) {
            return temp;
        }
        return (temp * a) % c;
    }
}
