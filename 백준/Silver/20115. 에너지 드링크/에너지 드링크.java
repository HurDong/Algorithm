import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 합칠 때 하나가 반이 된다.
        // 3 2 10 9 6
        // 10+2/2 = 11
        // 11 + 3/2 = 12.5
        // 12.5 + 6/2 = 15.5
        // 15.5 + 9/2 = 20
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] drink = new int[n];
        for (int i = 0; i < n; i++) {
            drink[i] = sc.nextInt();
        }
        Arrays.sort(drink);
        double answer = drink[n - 1];
        for (int i = 0; i < n - 1; i++) {
            answer += (double) drink[i] / 2;
        }
        System.out.println(answer);
    }
}
