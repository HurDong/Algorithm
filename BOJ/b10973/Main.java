package b10973;

import java.util.Scanner;

public class Main {
    public static boolean prev_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] <= a[i])
            i -= 1;
        if (i <= 0)
            return false; // 이전 순열이 없음

        int j = a.length - 1;
        while (a[j] >= a[i - 1])
            j -= 1;
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (prev_permutation(a)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }
}
