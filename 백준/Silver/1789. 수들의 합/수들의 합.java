import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        long count = 0;
        for (int i = 1; sum <= n; i++) {
            sum += i;
            count++;
        }
        System.out.println(count - 1);
    }
}
