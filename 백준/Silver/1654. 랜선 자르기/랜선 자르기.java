import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] lans = new long[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            lans[i] = sc.nextLong();
            max = Math.max(lans[i], max);
        }
        long start = 1;
        long end = max;
        while (start <= end) {
            long count = 0;
            long mid = (start + end) / 2;
            for (long lan : lans) {
                count += lan / mid;
            }
            if (count >= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
