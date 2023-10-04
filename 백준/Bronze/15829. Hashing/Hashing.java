import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String c = sc.next();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (c.charAt(i) - 96) * Math.pow(31, i);
        }
        System.out.println(sum);
    }
}
