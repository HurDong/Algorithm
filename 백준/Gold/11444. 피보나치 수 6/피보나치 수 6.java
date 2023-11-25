import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[][] result = { { 1, 0 }, { 0, 1 } };
        long[][] fibo = { { 1, 1 }, { 1, 0 } };
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, fibo);
            }
            fibo = multiply(fibo, fibo);
            n /= 2;
        }
        System.out.println(result[0][1]);
    }

    private static long[][] multiply(long[][] result, long[][] fibo) {
        long[][] temp = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += result[i][k] * fibo[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }
        return temp;
    }
}
