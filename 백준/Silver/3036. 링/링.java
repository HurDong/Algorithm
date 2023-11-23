import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int firstRadius = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int radius = sc.nextInt(); // 다른 원의 반지름
            int gcdValue = gcd(firstRadius, radius);
            System.out.println(firstRadius / gcdValue + "/" + radius / gcdValue);
        }
    }
}
