package SWEA.s1959;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            String s = sc.nextLine();
            String[] elements = s.split(" ");
            int[] A = new int[elements.length];
            s = sc.nextLine();
            elements = s.split(" ");
            int[] B = new int[elements.length];
            System.out.println(findAnswer(A, B));
        }
    }

    private static int findAnswer(int[] a, int[] b) {
        int answer = 0;
        if (a.length < b.length) {
            // a를 움직이자.
        } else if (a.length > b.length) {
            // b를 움직이자.
        } else {
            // 같을 때는 움직일 수 없다.
            for (int i = 0; i < a.length; i++) {
                answer += a[i] * b[i];
            }
        }
        return answer;
    }
}
