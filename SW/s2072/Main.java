package SW.s2072;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testNum = 1;
        while (T-- > 0) {
            int answer = 0;
            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                if (num % 2 == 1) {
                    answer += num;
                }
            }
            System.out.println("#" + testNum + " " + answer);
            testNum++;
        }
    }
}
