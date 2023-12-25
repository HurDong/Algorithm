package b2960;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] isErased = new boolean[N + 1];
        int count = 0;

        for (int i = 2; i <= N; i++) {
            if (!isErased[i]) {
                for (int j = i; j <= N; j += i) {
                    if (!isErased[j]) {
                        isErased[j] = true;
                        count++;
                        if (count == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }

}
