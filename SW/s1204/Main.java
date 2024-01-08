package SW.s1204;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int testNum = sc.nextInt();
            final int studentNum = 1000;
            int[] students = new int[101];
            int answer = 0;
            int idx = -1;
            for (int i = 0; i < studentNum; i++) {
                int num = sc.nextInt();
                students[num]++;
            }
            for (int i = 0; i < 101; i++) {
                if (answer <= students[i]) {
                    answer = students[i];
                    idx = i;
                }
            }
            System.out.println("#" + testNum + " " + idx);
        }
    }
}