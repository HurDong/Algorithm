import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] small = new int[9];
        int sum = 0;
        int fake1 = 0, fake2 = 0;
        for (int i = 0; i < 9; i++) {
            small[i] = sc.nextInt();
            sum += small[i];
        }
        Arrays.sort(small);
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int fakeSum = 0;
                fakeSum = small[i] + small[j];
                if (sum - fakeSum == 100) {
                    fake1 = i;
                    fake2 = j;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == fake1 || i == fake2) {

            } else {
                System.out.println(small[i]);
            }
        }
    }
}
