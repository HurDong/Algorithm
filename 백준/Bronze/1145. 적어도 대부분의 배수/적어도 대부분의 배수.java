import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
        }
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int target = lcm(lcm(num[i], num[j]), num[k]);
                    if (target < small)
                        small = target;
                }
            }
        }
        System.out.println(small);
    }

    public static int lcm(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int lcm = max;
        while (true) {
            if (lcm % min == 0) {
                return lcm;
            } else {
                lcm += max;
            }
        }
    }
}
